package hu.progtech.bead;

import java.sql.*;
import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> logininfo = new HashMap<String,String>();
    IDandPasswords() throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM universe.users";
        Statement statement = mySQLConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);

      /*  String sql2 = "INSERT INTO universe.users (name, password) VALUES (? , ?)";
        PreparedStatement statement2 = mySQLConnection.prepareStatement(sql2);
        statement2.setString(1,"agy2");
        statement2.setString(2,"dfeggr");
        System.out.println(statement2.executeUpdate());
*/
        int count = 0;
      //  Logger logger = Logger.getLogger(IDandPasswords.class);
      //  logger.info("ez egy teszt");
      //  org.apache.logging.log4j.Logger
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

    protected HashMap getLogininfo(){
        return logininfo;
    }
}
