package hu.progtech.bead;

import javax.swing.*;
import java.util.ArrayList;

public class UniversesForm {
    private JPanel panelUniverses;
    private JList listUniverses;
    private JTextField textFieldUniverseName;
    private JButton buttonDelete;
    private JButton buttonEdit;
    private JButton buttonNew;
    private JButton buttonVissza;
    public JFrame universesFrame;

    ArrayList<JList> lists = new ArrayList<>();
    ArrayList<JLabel> listLabels = new ArrayList<>();
    ArrayList<JScrollPane> scrollPanes = new ArrayList<>();
    ArrayList<JButton> addButtons = new ArrayList<>();

    String universe_id;
    String userID;

    String[] celestialBodyTypes = new String[]{"planets","stars","galaxies"};

    UniversesForm(){



    }

    private static class UniversesFormHolder {
        private static final UniversesForm INSTANCE = new UniversesForm();
    }

    public static UniversesForm getInstance() {
        return UniversesForm.UniversesFormHolder.INSTANCE;
    }
}
