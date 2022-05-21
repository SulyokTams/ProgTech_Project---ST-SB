package hu.progtech.bead;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
	    IDandPasswords idandPasswords = new IDandPasswords();

        LoginPage loginPage = new LoginPage(idandPasswords.getLogininfo());
    }
}
