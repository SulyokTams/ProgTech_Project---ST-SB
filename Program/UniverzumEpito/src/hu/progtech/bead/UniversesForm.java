package hu.progtech.bead;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class UniversesForm {
    public JPanel panelUniverses;
    String UniverseuserID;
    private JList listUniverses;
    private JTextField textFieldUniverseName;
    private JButton buttonDelete;
    private JButton buttonEdit;
    private JButton buttonNew;
    private JButton buttonVissza;
    private JScrollPane scrollPaneUniverses;
    public JFrame universesFrame;



    UniversesForm(String universeuserID) throws SQLException {
        UniverseuserID = universeuserID;
        DefaultListModel dm = new DefaultListModel();
        dm.addAll(UniverseCRUD.select(UniverseuserID));
        listUniverses.setModel(dm);
        System.out.println(Arrays.toString(UniverseCRUD.select(UniverseuserID).toArray()));
        listUniverses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


      //  listUniverses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
        private static  UniversesForm INSTANCE = null;

        static {
            try {
                INSTANCE = new UniversesForm(null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static UniversesForm getInstance() {
        return UniversesForm.UniversesFormHolder.INSTANCE;
    }
}
