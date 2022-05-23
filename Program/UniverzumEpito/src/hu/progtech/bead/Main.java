package hu.progtech.bead;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

       // LoginPage loginPage = new LoginPage("");
       // RegisterPage registerPage = new RegisterPage();
       // WelcomePage welcomePage = new WelcomePage("2");
      //  UniversePage universePage = new UniversePage("1");

        JFrame loginFrame = new JFrame("Univerzum készítő - Bejelentkezés");
        loginFrame.setContentPane(new LoginForm().panelLogin);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(500, 500);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }
}
