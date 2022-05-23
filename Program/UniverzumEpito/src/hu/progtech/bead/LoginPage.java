/*package hu.progtech.bead;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();

    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    JTextField usernameField  = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel usernameLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();

    LoginPage(String labelMessage){
        usernameLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        usernameField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton.setBounds(225,200,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        messageLabel.setBounds(25,270,400,70);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));
        messageLabel.setText(labelMessage);

        frame.add(usernameLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(usernameField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== registerButton){
            usernameField.setText("");
            userPasswordField.setText("");
            frame.dispose();
            RegisterPage registerPage = new RegisterPage();
        }
        if (e.getSource()==loginButton){
            String username = usernameField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            try {
                if (IDandPasswords.containsUser(username)!=null){
                    if (IDandPasswords.containsUser(username).password.equals(password)){
                        messageLabel.setForeground(Color.GREEN);
                        messageLabel.setText("Login successful");
                        frame.dispose();
                        try {
                            WelcomePage welcomePage = new WelcomePage(IDandPasswords.containsUser(username).userID);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }
                    else{
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Wrong password");
                    }
                }
                else{
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Username not found");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}*/
