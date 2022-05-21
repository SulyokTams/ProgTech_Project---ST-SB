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

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");
    JButton addButton = new JButton("Add Universe");
    JButton editButton = new JButton("Edit Universe");
    JButton deleteButton = new JButton("Delete Universe");


    JLabel listLabel = new JLabel("Universe List");

    WelcomePage(String username,String userID) throws SQLException {

        welcomeLabel.setBounds(10,10,400,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        welcomeLabel.setText("Welcome " + "username!");

        MySQLConnection mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM universe.universes WHERE user_id="+userID;
        Statement statement = mySQLConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int count = 0;
        ArrayList<String> data = new ArrayList<>();
        while(result.next()){
            String name = result.getString("name");
            String user_id = result.getString("user_id");
            data.add("Universe " + count + " " + name + " " + user_id);
            System.out.println(data.get(count));
            count++;

        }

        statement.close();
        JList universeList = new JList(data.toArray());
        JScrollPane jcp = new JScrollPane(universeList);
        jcp.setBounds(800,70,370,680);

        universeList.setFont(new Font(null,Font.PLAIN,35));
        universeList.setBorder(new EmptyBorder(0,10, 10, 10));

        universeList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());

                    System.out.println("index: "+index);
                } else if (evt.getClickCount() == 3) {

                    // Triple-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    System.out.println("index: "+index);
                }
            }
        });

        listLabel.setBounds(785,10,400,50);
        listLabel.setHorizontalAlignment(SwingConstants.CENTER);
        listLabel.setFont(new Font(null,Font.PLAIN,35));

        addButton.setBounds(25,150,150,50);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        editButton.setBounds(25,300,150,50);
        editButton.setFocusable(false);
        editButton.addActionListener(this);
        deleteButton.setBounds(25,450,150,50);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.add(addButton);
        frame.add(editButton);
        frame.add(deleteButton);
        frame.add(jcp);
        frame.add(listLabel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
