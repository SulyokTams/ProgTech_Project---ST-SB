package hu.progtech.bead;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UniversePage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");

    String universe_id;
    JLabel idLabel = new JLabel("id");
    JTextField idTextField = new JTextField();
    ArrayList<JList> lists = new ArrayList<JList>();
    ArrayList<JLabel> listLabels = new ArrayList<JLabel>();
    ArrayList<JScrollPane> scrollPanes = new ArrayList<JScrollPane>();
    ArrayList<JButton> functionButtons = new ArrayList<JButton>();

    UniversePage(String universe_id) throws SQLException {
        this.universe_id = universe_id;

        String[] types = new String[]{"planets","stars","galaxies"};
        createLists(types);

        String[] buttonTypes = new String[]{"add","edit","delete"};
        createFunctionButtons(buttonTypes);
        addListSelectionListeners();

        createFrame();
    }
    public void addListSelectionListeners(){
        for (int j=0;j<3;j++){
            lists.get(j).addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent le) {
                    JList list2 = (JList)le.getSource();
                    for (JList list : lists) {
                        if (list != list2 && list.getSelectedIndex()!=-1) {
                            list.clearSelection();
                        }
                    }
                }});
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
            lists.get(i).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            lists.get(i).setFont(new Font(null,Font.PLAIN,25));
            lists.get(i).setBorder(new EmptyBorder(0,0, 10, 0));

            listLabels.add(new JLabel(types[i].substring(0, 1).toUpperCase() + types[i].substring(1)));
            listLabels.get(i).setBounds(i*300 + 285,10,300,50);

            listLabels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            listLabels.get(i).setFont(new Font(null,Font.PLAIN,35));

            frame.add(scrollPanes.get(i));
            frame.add(listLabels.get(i));
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


    @Override
    public void actionPerformed(ActionEvent e) {
        //ADD
        if (e.getSource()== functionButtons.get(0)){
     //       int index = list.locationToIndex(evt.getPoint());
        }
    }
}