package hu.progtech.bead;

import org.apache.log4j.Logger;

import java.sql.*;

public class MySQLConnection {

     Connection connection;
    public MySQLConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/universe";
        String username = "root2";
        String password = "password";

        connection = DriverManager.getConnection(jdbcURL,username,password);
        Logger logger = Logger.getLogger(MySQLConnection.class);
        logger.info("MySQLConnection létrejött.");
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
