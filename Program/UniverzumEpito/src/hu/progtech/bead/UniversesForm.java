package hu.progtech.bead;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UniversesForm {
    public JPanel panelUniverses;
    private JList listUniverses;
    private JTextField textFieldUniverseName;
    private JButton buttonDelete;
    private JButton buttonEdit;
    private JButton buttonNew;
    private JButton buttonVissza;
    private JScrollPane scrollPaneUniverses;
    public JFrame universesFrame;
    //String UniverseuserID;


    UniversesForm(){
        //this.UniverseuserID = userID;


        buttonVissza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldUniverseName.setText("");
                LoginForm.getInstance().loginFrame.setVisible(true);
                UniversesForm.getInstance().universesFrame.setVisible(false);
            }
        });
    }

    private static class UniversesFormHolder {
        private static final UniversesForm INSTANCE = new UniversesForm();
    }

    public static UniversesForm getInstance() {
        return UniversesForm.UniversesFormHolder.INSTANCE;
    }
}
