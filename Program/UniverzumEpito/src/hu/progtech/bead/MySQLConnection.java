package hu.progtech.bead;

import java.sql.*;

public class MySQLConnection {
     Connection connection;
    public MySQLConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/universe";
        String username = "root2";
        String password = "password";

        connection = DriverManager.getConnection(jdbcURL,username,password);
    }
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
