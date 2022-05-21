package hu.progtech.bead;

import java.sql.*;
import java.util.HashMap;

public class IDandPasswords {
    static HashMap<String,String> logininfo = new HashMap<String,String>();
    static MySQLConnection mySQLConnection;
    IDandPasswords() throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM universe.users";
        Statement statement = mySQLConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        int count = 0;
        while(result.next()){
            String username = result.getString("name");
            String userpassword = result.getString("password");
            count++;
            logininfo.put(username,userpassword);
            System.out.println("User " + count + " " + username + " " + userpassword);
        }
        System.out.println(logininfo.toString());

        statement.close();
    }

    protected static HashMap getLogininfo(){
        return logininfo;
    }

    public static void insertUser(String username, String password) throws SQLException {
        String sql2 = "INSERT INTO universe.users (name, password) VALUES (? , ?)";
        PreparedStatement statement2 = mySQLConnection.prepareStatement(sql2);
        statement2.setString(1,username);
        statement2.setString(2,password);
        logininfo.put(username,password);
        System.out.println(statement2.executeUpdate());
    }

}
