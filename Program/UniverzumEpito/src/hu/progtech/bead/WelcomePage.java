package hu.progtech.bead;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class WelcomePage implements BigPage {
    JFrame frame = new JFrame();

    ArrayList<JButton> functionButtons = new ArrayList<>();

    JList universeList;
    JScrollPane jcp;
    JLabel listLabel = new JLabel("Universe List");

    JLabel nameLabel = new JLabel("Name");
    JTextField nameTextField = new JTextField();
    String userID;

    WelcomePage(String userID) throws SQLException {
        this.userID = userID;

        createList();

        createColumnField();



        String[] buttonTypes = new String[]{"add","edit","delete"};
        createFunctionButtons(buttonTypes);
        createFrame();
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

    @Override
    public void createFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void createList() throws SQLException {
        listLabel.setBounds(785,10,400,50);
        listLabel.setHorizontalAlignment(SwingConstants.CENTER);
        listLabel.setFont(new Font(null,Font.PLAIN,35));

        universeList = new JList(UniverseCRUD.select(userID).toArray());
        universeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        universeList.setFont(new Font(null,Font.PLAIN,35));
        universeList.setBorder(new EmptyBorder(0,0, 10, 0));

        jcp = new JScrollPane(universeList);
        jcp.setBounds(800,70,370,430);


        universeList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 1) {

                    // Single-click detected
                    nameTextField.setText(UniverseCRUD.universes.get(universeList.getSelectedIndex()).name);
                    nameTextField.setFont(new Font(null,Font.PLAIN,22));
                    nameTextField.setMargin(new Insets(0,5,0,0));
                }
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    try {
                        UniversePage universePage = new UniversePage(UniverseCRUD.universes.get(index).id,userID);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        frame.add(jcp);
        frame.add(listLabel);
    }

    @Override
    public void createColumnField() {
        nameLabel.setBounds(120,600,200,50);
        nameLabel.setFont(new Font(null,Font.PLAIN,25));
        nameTextField.setBounds(120,650,200,50);

        frame.add(nameLabel);
        frame.add(nameTextField);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //ADD
            if (e.getSource()== functionButtons.get(0)){
                if (! nameTextField.getText().equals("")){
                    try {
                        UniverseCRUD.insert(userID,nameTextField.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        //EDIT
        if (e.getSource() == functionButtons.get(1)){
            if (!nameTextField.getText().equals("")){
                try {
                UniverseCRUD.update(userID,nameTextField.getText(),
                           UniverseCRUD.universes.get(universeList.getSelectedIndex()).id);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //DELETE
        if (e.getSource() == functionButtons.get(2)){
            if(universeList.getSelectedIndex()!=-1){
                try {
                    UniverseCRUD.delete(UniverseCRUD.universes.get(universeList.getSelectedIndex()).id);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        try {
            DefaultListModel dm =  new DefaultListModel();
            dm.addAll(UniverseCRUD.select(userID));
            universeList.setModel(dm);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
