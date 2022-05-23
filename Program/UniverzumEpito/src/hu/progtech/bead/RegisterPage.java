package hu.progtech.bead;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class RegisterPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton createButton = new JButton("Create user");
    JTextField usernameField  = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JPasswordField passwordAgainField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel passWordAgainLabel = new JLabel("Password again:");
    JLabel messageLabel = new JLabel();

    RegisterPage(){

        usernameLabel.setBounds(58,100,75,25);
        userPasswordLabel.setBounds(58,150,75,25);

        usernameField.setBounds(135,100,200,25);
        userPasswordField.setBounds(135,150,200,25);

        passWordAgainLabel.setBounds(25,200,100,25);
        passwordAgainField.setBounds(135,200,200,25);


        createButton.setBounds(135,250,120,25);
        createButton.setFocusable(false);
        createButton.addActionListener(this);


        messageLabel.setBounds(25,270,400,70);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        frame.add(usernameLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(usernameField);
        frame.add(userPasswordField);
        frame.add(passWordAgainLabel);
        frame.add(passwordAgainField);
        frame.add(createButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==createButton){
            String username = usernameField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            String confirm = String.valueOf(passwordAgainField.getPassword());

            ArrayList<User> loginfo = null;
            try {
                loginfo = IDandPasswords.getLogininfo();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            for (User entry : loginfo)
                if (entry.username.equals(username)){
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Username already exists!");
                    return;
                }
            if (!password.equals(confirm)){

                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Wrong confirmation!");
            }
            else{
                try {
                    IDandPasswords.insertUser(username,password);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                frame.dispose();
                LoginPage loginPage = new LoginPage("Successful Registration");
                loginPage.messageLabel.setForeground(Color.GREEN);
            }
        }
    }
}
