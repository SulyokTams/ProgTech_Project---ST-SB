package hu.progtech.bead;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm implements ActionListener{
    public JPanel panelLogin;
    private JTextField textFieldName;
    private JPasswordField passwordFieldPass;
    private JButton buttonLogin;
    private JButton buttonRegister;
    private JLabel labelMessage;

    @Override
    public void actionPerformed(ActionEvent e) {

        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldName.setText("");
                passwordFieldPass.setText("");
                RegisterPage registerPage = new RegisterPage();
            }
        });

        if (e.getSource()==buttonLogin){
            String username = textFieldName.getText();
            String password = String.valueOf(passwordFieldPass.getPassword());

            try {
                if (IDandPasswords.containsUser(username)!=null){
                    if (IDandPasswords.containsUser(username).password.equals(password)){
                        labelMessage.setForeground(Color.GREEN);
                        labelMessage.setText("Login successful");
                        try {
                            WelcomePage welcomePage = new WelcomePage(IDandPasswords.containsUser(username).userID);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }
                    else{
                        labelMessage.setForeground(Color.RED);
                        labelMessage.setText("Wrong password");
                    }
                }
                else{
                    labelMessage.setForeground(Color.RED);
                    labelMessage.setText("Username not found");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
