package hu.progtech.bead;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IDandPasswords {
    static ArrayList<User> logininfo = new ArrayList<User>();
    static MySQLConnection mySQLConnection;
    IDandPasswords() throws SQLException {
        mySQLConnection = new MySQLConnection();

    }
    protected static ArrayList<User> selectLogininfo() throws SQLException {
        String sql = "SELECT * FROM universe.users";
        Statement statement = mySQLConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        int count = 0;
        while(result.next()){
            String userID = result.getString("id");
            String username = result.getString("name");
            String userpassword = result.getString("password");
            count++;
            logininfo.add(new User(userID,username,userpassword));
            System.out.println("User " + count + " " + username + " " + userpassword);
        }
        System.out.println(logininfo.toString());

        statement.close();
        return logininfo;
    }
    protected static User containsUser(String username){
        for (User entry : getLogininfo())
            if (entry.username.equals(username)){
                return entry;
            }
        return null;
    }
    protected static ArrayList<User> getLogininfo(){

        return logininfo;
    }

    public static void insertUser(String username, String password) throws SQLException {
        String sql2 = "INSERT INTO universe.users (name, password) VALUES (? , ?)";
        PreparedStatement statement2 = mySQLConnection.prepareStatement(sql2);
        statement2.setString(1,username);
        statement2.setString(2,password);
        logininfo = selectLogininfo();
        System.out.println(statement2.executeUpdate());
    }

}
