package hu.progtech.bead;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UniversePage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");

    JList selectedList;
    String universe_id;
    ArrayList<JLabel> columnLabels = new ArrayList<>();
    ArrayList<JTextField> columnTextFields = new ArrayList<>();

    String[] celestialBodyTypes = new String[]{"planets","stars","galaxies"};

    ArrayList<JList> lists = new ArrayList<JList>();
    ArrayList<JLabel> listLabels = new ArrayList<JLabel>();
    ArrayList<JScrollPane> scrollPanes = new ArrayList<JScrollPane>();
    ArrayList<JButton> functionButtons = new ArrayList<JButton>();
    ArrayList<JButton> addButtons = new ArrayList<JButton>();

    UniversePage(String universe_id) throws SQLException {
        this.universe_id = universe_id;


        createLists(celestialBodyTypes);

        String[] buttonTypes = new String[]{"edit","delete"};
        createFunctionButtons(buttonTypes);
        addListSelectionListeners();
        createColumnFields();
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
                            addButtons.get(i).setEnabled(false);
                        }
                        else if(lists.get(i) == selectedList){
                            addButtons.get(i).setEnabled(true);
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

    public void createLists(String[] types) throws SQLException {
        for (int i = 0; i<types.length; i++){

            lists.add(new JList(CelestialBodiesCRUD.select(types[i],universe_id).toArray()));

            scrollPanes.add(new JScrollPane(lists.get(i)));
            scrollPanes.get(i).setBounds((i+1)*300,70,270,430);

            lists.get(i).setFont(new Font(null,Font.PLAIN,25));
            lists.get(i).setBorder(new EmptyBorder(0,0, 10, 0));

            addButtons.add(new JButton("Add " + types[i].substring(0,types[i].length()-1)
                    .replace("xie","xy")));
            addButtons.get(i).setBounds((i+1)*300+60,520,150,50);
            addButtons.get(i).setFocusable(false);
            addButtons.get(i).addActionListener(this);
            addButtons.get(i).setEnabled(false);

            listLabels.add(new JLabel(types[i].substring(0, 1).toUpperCase() + types[i].substring(1)));
            listLabels.get(i).setBounds(i*300 + 285,10,300,50);

            listLabels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            listLabels.get(i).setFont(new Font(null,Font.PLAIN,35));

            frame.add(scrollPanes.get(i));
            frame.add(listLabels.get(i));
            frame.add(addButtons.get(i));
        }
    }

    public void createFunctionButtons(String[] types){
        for (int i = 0; i< types.length;i++){
            functionButtons.add(new JButton(types[i].substring(0, 1).toUpperCase() + types[i].substring(1)));
            functionButtons.get(i).setBounds(25,(i+1)*150,150,50);
            functionButtons.get(i).setFocusable(false);
            functionButtons.get(i).addActionListener(this);
            frame.add(functionButtons.get(i));
        }
    }
    public void updateColumnLabels(){
        if (selectedList==null) {
            for (int i=0;i<4;i++){
                columnLabels.get(i).setText("");
            }
        }
        else{
            columnLabels.get(0).setText("Name");
            columnLabels.get(1).setText("Diameter");
            columnLabels.get(2).setText("Mass");

            if (selectedList.equals(lists.get(0))){

                columnLabels.get(3).setText("Orbital Period");
            }
            else  if (selectedList.equals(lists.get(1))){
                columnLabels.get(3).setText("Brightness");
            }
            else  if (selectedList.equals(lists.get(2))){
                columnLabels.get(3).setText("Number of stars");
            }
        }
    }

    public void createColumnFields(){
        for (int i = 0; i< 4;i++){
            columnLabels.add(new JLabel());
            columnLabels.get(i).setBounds(i*250 + 120,600,200,50);
            columnLabels.get(i).setFont(new Font(null,Font.PLAIN,25));
            columnTextFields.add(new JTextField());
            columnTextFields.get(i).setBounds(i*250 + 120,650,200,50);
            frame.add(columnLabels.get(i));
            frame.add(columnTextFields.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ADD
        String[] values = new String[4];
        for (int i = 0; i < 3;i++){
            if (e.getSource()== addButtons.get(i)){
                if(selectedList!=null && selectedList==lists.get(i)){

                    for(int j=0;j<4;j++){
                        values[j] = columnTextFields.get(j).getText();
                    }
                    try {
                        CelestialBodiesCRUD.insert(celestialBodyTypes[i],universe_id,values);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }
        //EDIT

        if (e.getSource() == functionButtons.get(0)){
            for (int i = 0; i < 3;i++){

                if(selectedList!=null && selectedList==lists.get(i)){

                    for(int j=0;j<4;j++){
                        values[j] = columnTextFields.get(j).getText();
                    }
                    try {
                        if(i==0) {
                            CelestialBodiesCRUD.update(celestialBodyTypes[i],universe_id,values,
                                    CelestialBodiesCRUD.planets.get(selectedList.getSelectedIndex()).id);}
                        else if(i==1) {
                            CelestialBodiesCRUD.update(celestialBodyTypes[i],universe_id,values,
                                    CelestialBodiesCRUD.stars.get(selectedList.getSelectedIndex()).id); }
                        else if(i==2) {
                            CelestialBodiesCRUD.update(celestialBodyTypes[i],universe_id,values,
                                    CelestialBodiesCRUD.galaxies.get(selectedList.getSelectedIndex()).id); }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        //DELETE

        if (e.getSource() == functionButtons.get(1)){
            for (int i = 0; i < 3;i++){

                if(selectedList!=null && selectedList==lists.get(i)){

                    for(int j=0;j<4;j++){
                    }
                    try {
                        if(i==0) {
                            CelestialBodiesCRUD.delete(celestialBodyTypes[i],
                                    CelestialBodiesCRUD.planets.get(selectedList.getSelectedIndex()).id);
                        }
                        else if(i==1) {
                            CelestialBodiesCRUD.delete(celestialBodyTypes[i],
                                    CelestialBodiesCRUD.stars.get(selectedList.getSelectedIndex()).id);
                        }
                        else if(i==2) {
                            CelestialBodiesCRUD.delete(celestialBodyTypes[i],
                                    CelestialBodiesCRUD.galaxies.get(selectedList.getSelectedIndex()).id);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}