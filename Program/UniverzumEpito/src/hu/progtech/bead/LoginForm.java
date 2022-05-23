package hu.progtech.bead;

import com.mysql.cj.log.Log;
import org.apache.log4j.Logger;

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
                textFieldName.setText("");
                passwordFieldPass.setText("");

                RegisterForm.getInstance().registerFrame = new JFrame("Univerzum Készítő - Regisztráció");
                RegisterForm.getInstance().registerFrame.setContentPane(new RegisterForm().panelRegister);
                RegisterForm.getInstance().registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                RegisterForm.getInstance().registerFrame.setSize(500, 500);
                RegisterForm.getInstance().registerFrame.setLocationRelativeTo(null);
                RegisterForm.getInstance().registerFrame.setVisible(true);
                LoginForm.getInstance().loginFrame.setVisible(false);

                Logger logger = Logger.getLogger(LoginForm.class);
                logger.info("Regisztrációs gomb megnyomva.");
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
                                showMessageDialog(null, "Sikeres Bejelentkezés!", "Siker!", JOptionPane.INFORMATION_MESSAGE);

                                UniversesForm.getInstance().UniverseuserID = IDandPasswords.containsUser(username).userID;
                                UniversesForm.getInstance().universesFrame = new JFrame("Univerzum Készítő - Univerzumok");
                                UniversesForm.getInstance().universesFrame.setContentPane(new WelcomePage(UniversesForm.getInstance().UniverseuserID));
                                LoginForm.getInstance().loginFrame.setVisible(false);
                            }
                            else{
                                labelMessage.setForeground(Color.RED);
                                labelMessage.setText("Hibás Jelszó!");

                                Logger logger = Logger.getLogger(String.valueOf(LoginForm.class));
                                logger.info("Hibás jelszó.");
                            }
                        }
                        else{
                            labelMessage.setForeground(Color.RED);
                            labelMessage.setText("Nincs ilyen nevű felhasználó!");
                            Logger logger = Logger.getLogger(String.valueOf(LoginForm.class));
                            logger.info("Nincs ilyen nevű felhasználó!");
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

