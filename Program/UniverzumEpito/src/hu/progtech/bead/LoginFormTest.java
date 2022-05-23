package hu.progtech.bead;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;
import static org.junit.jupiter.api.Assertions.*;

class LoginFormTest {

    @Test
    void registerFormButton(){
        LoginForm.getInstance().buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = LoginForm.getInstance().textFieldName.getText();
                String pass = String.valueOf(LoginForm.getInstance().passwordFieldPass);

                assertNull(name);
                assertNull(pass);
            }
        });
    }

    @Test
    void errorMessageEquals(){
        LoginForm.getInstance().buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = "asd";
                String password = "asd";

                try {
                    if (IDandPasswords.containsUser(username)!= null){
                        if (!IDandPasswords.containsUser(username).password.equals(password)){
                        }
                        else{
                            String message = ("Hibás Jelszó!");
                            assertEquals(message, LoginForm.getInstance().labelMessage);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}