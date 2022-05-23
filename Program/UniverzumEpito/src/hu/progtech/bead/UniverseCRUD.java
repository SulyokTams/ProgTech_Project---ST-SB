package hu.progtech.bead;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UniverseCRUD {
    static ArrayList<Universe> universes;
    static MySQLConnection mySQLConnection;
    public static ArrayList<String> select(String userID) throws SQLException {

        mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM universe.universes WHERE user_id="+userID;
        Statement statement = mySQLConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        ArrayList<String> data = new ArrayList<>();
        universes = new ArrayList<>();

        while(result.next()){
            String name = result.getString("name");
            String user_id = result.getString("user_id");
            String universe_id = result.getString("id");
            data.add(name);
            universes.add(new Universe(universe_id,name,user_id));
        }
        statement.close();
        mySQLConnection.close();
        return data;
    }
    public static void insert(String userID,String value) throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "INSERT INTO universe.universes VALUES (NULL, ?, ?)";
        PreparedStatement statement = mySQLConnection.prepareStatement(sql);
        statement.setString(1,value);
        statement.setString(2,userID);
        System.out.println(statement.executeUpdate());

        statement.close();
        mySQLConnection.close();
    }

    public static void update(String userID,String value,String id) throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "UPDATE universe.universes SET `name` = ?, `user_id` = ? WHERE `id` = ?;";
        PreparedStatement statement = mySQLConnection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setString(2,userID);
        statement.setString(3,id);
        System.out.println(statement.executeUpdate());

        statement.close();
        mySQLConnection.close();
    }

    public static void delete(String id) throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "DELETE FROM universe.universes WHERE id = ?;";
        PreparedStatement statement = mySQLConnection.prepareStatement(sql);
        statement.setString(1,id);
        System.out.println(statement.executeUpdate());

        statement.close();
        mySQLConnection.close();
    }
}
