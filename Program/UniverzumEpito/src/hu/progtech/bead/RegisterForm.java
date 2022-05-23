package hu.progtech.bead;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterForm implements ActionListener {
    private JTextField textFieldName;
    private JPasswordField passwordFieldPass;
    private JPasswordField passwordFieldPassAgain;
    private JButton buttonRegister;
    private JButton buttonVissza;
    private JLabel labelMessage;
    public JPanel panelRegister;
    public JFrame registerFrame;

    RegisterForm(){}

    private static class RegisterFormHolder {
        private static final RegisterForm INSTANCE = new RegisterForm();
    }

    public static RegisterForm getInstance() {
        return RegisterForm.RegisterFormHolder.INSTANCE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonRegister){
            String username = textFieldName.getText();
            String password = String.valueOf(passwordFieldPass.getPassword());
            String confirm = String.valueOf(passwordFieldPassAgain.getPassword());

            ArrayList<User> loginfo = null;
            try {
                loginfo = IDandPasswords.getLogininfo();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            for (User entry : loginfo)
                if (entry.username.equals(username)){
                    labelMessage.setForeground(Color.RED);
                    labelMessage.setText("Username already exists!");
                    return;
                }
            if (!password.equals(confirm)){

                labelMessage.setForeground(Color.RED);
                labelMessage.setText("Wrong confirmation!");
            }
            else{
                try {
                    IDandPasswords.insertUser(username,password);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                LoginForm loginPage = new LoginForm();
                loginPage.labelMessage.setForeground(Color.GREEN);
            }
        }
    }
}
