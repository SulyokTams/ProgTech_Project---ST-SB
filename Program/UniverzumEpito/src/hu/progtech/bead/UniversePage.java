package hu.progtech.bead;

import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class UniversePage implements BigPage {
    JFrame frame = new JFrame("Univerzum Építő - Égitestek");

    String universe_id;
    String userID;

    ArrayList<JLabel> columnLabels = new ArrayList<>();
    ArrayList<JTextField> columnTextFields = new ArrayList<>();

    String[] listTypes = new String[]{"planets","stars","galaxies"};

    JList selectedList;
    ArrayList<JList> lists = new ArrayList<>();
    ArrayList<JLabel> listLabels = new ArrayList<>();
    ArrayList<JScrollPane> scrollPanes = new ArrayList<>();
    ArrayList<JButton> functionButtons = new ArrayList<>();
    ArrayList<JButton> addButtons = new ArrayList<>();

    UniversePage(String universe_id, String userID) throws SQLException {
        this.universe_id = universe_id;
        this.userID = userID;

        createList(listTypes);

        String[] buttonTypes = new String[]{"Vissza","szerkesztés","törlés"};
        createFunctionButtons(buttonTypes);
        addListSelectionListeners();
        createColumnField();
        updateColumnLabels();
        createFrame();

    }
    public void addListSelectionListeners(){
        for (int j=0;j<3;j++){
            lists.get(j).addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent le) {
                    selectedList = (JList)le.getSource();
                    for (int i = 0;i<3;i++) {
                        if (lists.get(i) != selectedList && le.getValueIsAdjusting()) {
                            lists.get(i).clearSelection();
                        }
                        else if(lists.get(i) == selectedList){
                            if (i!=-1){
                                updateColumnTextFields(i);
                            }

                        }
                    }
                    updateColumnLabels();
                }});
        }
    }
    public void updateColumnTextFields(int j){
        if (selectedList==null||selectedList.getSelectedIndex()==-1) {
            for (int i=0;i<4;i++){
                columnTextFields.get(i).setText("");
            }
        }
        else if(j==0){
            columnTextFields.get(0).setText(CelestialBodiesCRUD.planets.get(selectedList.getSelectedIndex()).name);
            columnTextFields.get(1).setText(CelestialBodiesCRUD.planets.get(selectedList.getSelectedIndex()).diameter);
            columnTextFields.get(2).setText(CelestialBodiesCRUD.planets.get(selectedList.getSelectedIndex()).mass);
            columnTextFields.get(3).setText(CelestialBodiesCRUD.planets.get(selectedList.getSelectedIndex()).orbitalPeriod);
        }
        else  if(j==1){
            columnTextFields.get(0).setText(CelestialBodiesCRUD.stars.get(selectedList.getSelectedIndex()).name);
            columnTextFields.get(1).setText(CelestialBodiesCRUD.stars.get(selectedList.getSelectedIndex()).diameter);
            columnTextFields.get(2).setText(CelestialBodiesCRUD.stars.get(selectedList.getSelectedIndex()).mass);
            columnTextFields.get(3).setText(CelestialBodiesCRUD.stars.get(selectedList.getSelectedIndex()).brightness);
        }
        else  if(j==2){
            columnTextFields.get(0).setText(CelestialBodiesCRUD.galaxies.get(selectedList.getSelectedIndex()).name);
            columnTextFields.get(1).setText(CelestialBodiesCRUD.galaxies.get(selectedList.getSelectedIndex()).diameter);
            columnTextFields.get(2).setText(CelestialBodiesCRUD.galaxies.get(selectedList.getSelectedIndex()).mass);
            columnTextFields.get(3).setText(CelestialBodiesCRUD.galaxies.get(selectedList.getSelectedIndex()).numberOfStars);
        }
    }
    public void createFrame(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void createList(String[] types) throws SQLException {

        for (int i = 0; i<types.length; i++){

            lists.add(new JList(CelestialBodiesCRUD.select(types[i],universe_id).toArray()));

            scrollPanes.add(new JScrollPane(lists.get(i)));
            scrollPanes.get(i).setBounds((i+1)*300,70,270,430);

            lists.get(i).setFont(new Font(null,Font.PLAIN,25));
            lists.get(i).setBorder(new EmptyBorder(0,0, 10, 0));

            addButtons.add(new JButton());
            addButtons.get(i).setBounds((i+1)*300+60,520,150,50);
            addButtons.get(i).setFocusable(false);
            addButtons.get(i).addActionListener(this);

            listLabels.add(new JLabel());
            listLabels.get(i).setBounds(i*300 + 285,10,300,50);

            listLabels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            listLabels.get(i).setFont(new Font(null,Font.PLAIN,35));

            frame.add(scrollPanes.get(i));
            frame.add(listLabels.get(i));
            frame.add(addButtons.get(i));
        }
        addButtons.get(0).setText("Új bolygó");
        addButtons.get(1).setText("Új csillag");
        addButtons.get(2).setText("Új galaxis");
        listLabels.get(0).setText("Bolygók");
        listLabels.get(1).setText("Csillagok");
        listLabels.get(2).setText("Galaxisok");
    }

    public void createFunctionButtons(String[] types){
        for (int i = 0; i< types.length;i++){
            functionButtons.add(new JButton(types[i].substring(0, 1).toUpperCase() + types[i].substring(1)));
            functionButtons.get(i).setBounds(25,(i)*150+30,150,50);
            functionButtons.get(i).setFocusable(false);
            functionButtons.get(i).addActionListener(this);
            frame.add(functionButtons.get(i));
        }
    }

    public void createColumnField(){
        for (int i = 0; i< 4;i++){
            columnLabels.add(new JLabel());
            columnLabels.get(i).setBounds(i*250 + 120,600,200,50);
            columnLabels.get(i).setFont(new Font(null,Font.PLAIN,25));
            columnTextFields.add(new JTextField());
            columnTextFields.get(i).setBounds(i*250 + 120,650,200,50);
            columnTextFields.get(i).setFont(new Font(null,Font.PLAIN,22));
            columnTextFields.get(i).setMargin(new Insets(0,5,0,0));
            frame.add(columnLabels.get(i));
            frame.add(columnTextFields.get(i));
        }
    }

    public void updateColumnLabels(){
            columnLabels.get(0).setText("Név");
            columnLabels.get(1).setText("Átmérö");
            columnLabels.get(2).setText("Tömeg");
            if (selectedList == null){
                columnLabels.get(3).setText("K/F/Cs");
            }
            else if (selectedList.equals(lists.get(0))){
                columnLabels.get(3).setText("Keringési idő");
            }
            else  if (selectedList.equals(lists.get(1))){
                columnLabels.get(3).setText("Fényesség");
            }
            else  if (selectedList.equals(lists.get(2))){
                columnLabels.get(3).setText("Csillagok száma");
            }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //GO BACK
        if (e.getSource() == functionButtons.get(0)){
            try {
                WelcomePage welcomePage = new WelcomePage(userID);
                frame.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return;
        }
        int index = 0;
        //ADD
        String[] values = new String[4];
        for (int i = 0; i < 3;i++){
            if (e.getSource()== addButtons.get(i)){
                index = i;
                    for(int j=0;j<4;j++){
                        if (!columnTextFields.get(j).getText().equals("")) {
                            values[j] = columnTextFields.get(j).getText();
                        }
                        else {
                            return;
                        }
                    }

                    try {
                        CelestialBodiesCRUD.insert(listTypes[i],universe_id,values);
                        Logger logger = Logger.getLogger(WelcomePage.class);
                        logger.info("Sor hozzáadva");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger logger = Logger.getLogger(WelcomePage.class);
                        logger.info("Adatbázis hiba");
                    }
            }
        }
        //EDIT
        if (e.getSource() == functionButtons.get(1)){
            for (int i = 0; i < 3;i++){

                if(selectedList!=null && selectedList==lists.get(i)){
                    index = i;
                    for(int j=0;j<4;j++){
                        System.out.println(columnTextFields.get(j).getText().equals(""));
                        if (!columnTextFields.get(j).getText().equals(""))
                            values[j] = columnTextFields.get(j).getText();
                        else {
                            throw new NullPointerException();
                        }
                    }
                    try {
                        if(i==0) {
                            CelestialBodiesCRUD.update(listTypes[i],universe_id,values,
                                    CelestialBodiesCRUD.planets.get(selectedList.getSelectedIndex()).id);
                            Logger logger = Logger.getLogger(WelcomePage.class);
                            logger.info("Sor szerkesztve");
                        }
                        else if(i==1) {
                            CelestialBodiesCRUD.update(listTypes[i],universe_id,values,
                                    CelestialBodiesCRUD.stars.get(selectedList.getSelectedIndex()).id);
                            Logger logger = Logger.getLogger(WelcomePage.class);
                            logger.info("Sor szerkesztve");
                        }
                        else if(i==2) {
                            CelestialBodiesCRUD.update(listTypes[i],universe_id,values,
                                    CelestialBodiesCRUD.galaxies.get(selectedList.getSelectedIndex()).id);
                            Logger logger = Logger.getLogger(WelcomePage.class);
                            logger.info("Sor szerkesztve");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger logger = Logger.getLogger(WelcomePage.class);
                        logger.info("Adatbázis hiba");
                    }
                }
                else if(selectedList==null && selectedList==lists.get(i)){
                    throw new NullPointerException();
                }
            }
        }
        //DELETE

        if (e.getSource() == functionButtons.get(2)){
            for (int i = 0; i < 3;i++){

                if(selectedList!=null && selectedList==lists.get(i)){
                    index = i;
                    try {
                        if(i==0) {
                            CelestialBodiesCRUD.delete(listTypes[i],
                                    CelestialBodiesCRUD.planets.get(selectedList.getSelectedIndex()).id);
                            Logger logger = Logger.getLogger(WelcomePage.class);
                            logger.info("Sor törölve");
                        }
                        else if(i==1) {
                            CelestialBodiesCRUD.delete(listTypes[i],
                                    CelestialBodiesCRUD.stars.get(selectedList.getSelectedIndex()).id);
                            Logger logger = Logger.getLogger(WelcomePage.class);
                            logger.info("Sor törölve");
                        }
                        else if(i==2) {
                            CelestialBodiesCRUD.delete(listTypes[i],
                                    CelestialBodiesCRUD.galaxies.get(selectedList.getSelectedIndex()).id);
                            Logger logger = Logger.getLogger(WelcomePage.class);
                            logger.info("Sor törölve");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger logger = Logger.getLogger(WelcomePage.class);
                        logger.info("Adatbázis hiba");
                    }
                }
            }
        }
        try {
            DefaultListModel dm =  new DefaultListModel();
            if(index==0){
                dm.addAll(CelestialBodiesCRUD.select("planets",universe_id));
            }
            else if(index==1){
                dm.addAll(CelestialBodiesCRUD.select("stars",universe_id));
            }
            else if(index==2){
                dm.addAll(CelestialBodiesCRUD.select("galaxies",universe_id));
            }
            lists.get(index).setModel(dm);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex){

        }
    }
}