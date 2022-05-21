package hu.progtech.bead;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

    ArrayList<JList> lists = new ArrayList<JList>();
    ArrayList<JLabel> listLabels = new ArrayList<JLabel>();
    ArrayList<JScrollPane> scrollPanes = new ArrayList<JScrollPane>();
    ArrayList<JButton> functionButtons = new ArrayList<JButton>();

    ArrayList<Galaxy> galaxies;
    ArrayList<Star> stars;
    ArrayList<Planet> planets;

    UniversePage(String universe_id) throws SQLException {
        this.universe_id = universe_id;

        welcomeLabel.setBounds(10,10,400,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        welcomeLabel.setText("Welcome " + "username!");

        String[] types = new String[]{"planets","stars","galaxies"};
        createLists(types);

        String[] buttonTypes = new String[]{"add","edit","delete"};
        createFunctionButtons(buttonTypes);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void createLists(String[] types) throws SQLException {


        for (int i = 0; i<types.length; i++){

            lists.add(new JList(select(types[i]).toArray()));

            scrollPanes.add(new JScrollPane(lists.get(i)));
            scrollPanes.get(i).setBounds((i+1)*300,70,270,430);

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

    public ArrayList<String> select(String type) throws SQLException {

        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM "+ type +" WHERE universe_id="+universe_id;
        Statement statement = mySQLConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        ArrayList<String> data = new ArrayList<>();

        if (type.equals("galaxies")) {
            galaxies = new ArrayList<Galaxy>();
        }
        else if(type.equals("stars")){
            stars = new ArrayList<Star>();
        }
        else if(type.equals("planets")){
            planets = new ArrayList<Planet>();
        }

        while(result.next()){
            String id = result.getString("id");
            String name = result.getString("name");
            String diameter = result.getString("diameter");
            String mass = result.getString("mass");

            data.add(name);

            if (type.equals("galaxies")) {
                String numberOfStars = result.getString("numberOfStars");
                galaxies.add(new Galaxy(id,name,diameter,mass,numberOfStars,universe_id));
            }

            else if (type.equals("stars")) {
                String brightness = result.getString("brightness");
                stars.add(new Star(id,name,diameter,mass,brightness,universe_id));
            }
            else if (type.equals("planets")) {
                String orbitalPeriod = result.getString("orbitalPeriod");
                planets.add(new Planet(id,name,diameter,mass,orbitalPeriod,universe_id));
            }
        }

        statement.close();
        mySQLConnection.connection.close();
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}