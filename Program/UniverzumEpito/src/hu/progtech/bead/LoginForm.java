package hu.progtech.bead;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginForm{
    public JPanel panelLogin;
    public JTextField textFieldName;
    public JPasswordField passwordFieldPass;
    public JButton buttonLogin;
    public JButton buttonRegister;
    public JLabel labelMessage;
    public JFrame loginFrame;

    LoginForm(){
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldName.setText(null);
                passwordFieldPass.setText(null);

                RegisterForm.getInstance().registerFrame = new JFrame("Univerzum Készítő - Regisztráció");
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
                String username = textFieldName.getText();
                String password = String.valueOf(passwordFieldPass.getPassword());
                try {
                    if (IDandPasswords.containsUser(username)!=null){
                        if (IDandPasswords.containsUser(username).password.equals(password)){
                            showMessageDialog(null, "Sikeres Bejelentkezés!", "Siker!", JOptionPane.INFORMATION_MESSAGE);

                            //UniversesForm.getInstance().UniverseuserID = IDandPasswords.containsUser(username).userID;
                            UniversesForm.getInstance().universesFrame = new JFrame("Univerzum Készítő - Univerzumok");
                            UniversesForm.getInstance().universesFrame.setContentPane(new UniversesForm().panelUniverses);
                            UniversesForm.getInstance().universesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            UniversesForm.getInstance().universesFrame.setSize(800, 600);
                            UniversesForm.getInstance().universesFrame.setLocationRelativeTo(null);
                            UniversesForm.getInstance().universesFrame.setVisible(true);
                            LoginForm.getInstance().loginFrame.setVisible(false);
                        }
                        else{
                            labelMessage.setForeground(Color.RED);
                            labelMessage.setText("Hibás Jelszó!");
                        }
                    }
                    else{
                        labelMessage.setForeground(Color.RED);
                        labelMessage.setText("Nincs ilyen nevű felhasználó!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
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
