package hu.progtech.bead;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

       // LoginPage loginPage = new LoginPage("");
       // RegisterPage registerPage = new RegisterPage();
       // WelcomePage welcomePage = new WelcomePage("2");
      //  UniversePage universePage = new UniversePage("1");

        LoginForm.getInstance().loginFrame = new JFrame("Univerzum Készítő - Bejelentkezés");
        LoginForm.getInstance().loginFrame.setContentPane(new LoginForm().panelLogin);
        LoginForm.getInstance().loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginForm.getInstance().loginFrame.setSize(500, 500);
        LoginForm.getInstance().loginFrame.setLocationRelativeTo(null);
        LoginForm.getInstance().loginFrame.setVisible(true);

    }
}
