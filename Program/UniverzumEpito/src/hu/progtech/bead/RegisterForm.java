package hu.progtech.bead;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class RegisterForm{
    public JTextField textFieldName;
    public JPasswordField passwordFieldPass;
    public JPasswordField passwordFieldPassAgain;
    public JButton buttonRegister;
    public JButton buttonVissza;
    public JLabel labelMessage;
    public JPanel panelRegister;
    public JFrame registerFrame;

    RegisterForm(){
        buttonVissza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldName.setText(null);
                passwordFieldPass.setText(null);
                passwordFieldPassAgain.setText(null);

                LoginForm.getInstance().loginFrame.setVisible(true);
                RegisterForm.getInstance().registerFrame.setVisible(false);

                Logger logger = Logger.getLogger(RegisterForm.class);
                logger.info("Vissza a Bejelentkezési képernyőre gomb.");
            }
        });

        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        labelMessage.setText("Már van ilyen felhasználó!");
                        return;
                    }

                if (username.length() < 3){
                    labelMessage.setForeground(Color.RED);
                    labelMessage.setText("A név nem lehet kissebb mint 3!");
                    return;
                }

                if (username.length() == 0){
                    labelMessage.setForeground(Color.RED);
                    labelMessage.setText("A név nem lehet üres!");
                    return;
                }

                if (password.length() < 3){
                    labelMessage.setForeground(Color.RED);
                    labelMessage.setText("A jelszó nem lehet kissebb mint 3!");
                    return;
                }

                if (password.length() == 0){
                    labelMessage.setForeground(Color.RED);
                    labelMessage.setText("A jelszó nem lehet nem lehet üres!");
                    return;
                }

                if (!password.equals(confirm)){
                    labelMessage.setForeground(Color.RED);
                    labelMessage.setText("A jelszavak nem egyeznek meg!");
                }

                try {
                    IDandPasswords.insertUser(username,password);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                showMessageDialog(null, "Sikeres Regisztráció!", "Siker!", JOptionPane.INFORMATION_MESSAGE);
                RegisterForm.getInstance().registerFrame.setVisible(false);
                LoginForm.getInstance().loginFrame.setVisible(true);

                Logger logger = Logger.getLogger(RegisterForm.class);
                logger.info("Regisztráció Sikeres.");
            }
        });
    }

    private static class RegisterFormHolder {
        private static final RegisterForm INSTANCE = new RegisterForm();
    }

    public static RegisterForm getInstance() {
        return RegisterForm.RegisterFormHolder.INSTANCE;
    }
}
