package hu.progtech.bead;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm{
    public JPanel panelLogin;
    private JTextField textFieldName;
    private JPasswordField passwordFieldPass;
    private JButton buttonLogin;
    private JButton buttonRegister;
    public JLabel labelMessage;
    public JFrame loginFrame;

    LoginForm(){
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldName.setText("");
                passwordFieldPass.setText("");

                RegisterForm.getInstance().registerFrame = new JFrame("Univerzum készítő - Regisztráció");
                RegisterForm.getInstance().registerFrame.setContentPane(new RegisterForm().panelRegister);
                RegisterForm.getInstance().registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                RegisterForm.getInstance().registerFrame.setSize(500, 500);
                RegisterForm.getInstance().registerFrame.setLocationRelativeTo(null);
                RegisterForm.getInstance().registerFrame.setVisible(true);
                LoginForm.getInstance().loginFrame.setVisible(false);
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
    }

    private static class LoginFormHolder {
        private static final LoginForm INSTANCE = new LoginForm();
    }

    public static LoginForm getInstance() {
        return LoginFormHolder.INSTANCE;
    }
}
