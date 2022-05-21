package hu.progtech.bead;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CelestialBodiesCRUD {
    static ArrayList<Galaxy> galaxies;
    static ArrayList<Star> stars;
    static ArrayList<Planet> planets;
    static MySQLConnection mySQLConnection;

    public static ArrayList<String> select(String type,String universe_id) throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM "+ type +" WHERE universe_id="+universe_id;
        Statement statement = mySQLConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        ArrayList<String> data = new ArrayList<>();

        if (type.equals("galaxies")) {
            galaxies = new ArrayList<>();
        }
        else if(type.equals("stars")){
            stars = new ArrayList<>();
        }
        else if(type.equals("planets")){
            planets = new ArrayList<>();
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
   /* public static void insert(String type,String universe_id) throws SQLException {
        String sixthColumn="";
        String sql2 = "INSERT INTO universe."+ " (name, diameter,mass," + sixthColumn + "universe_id) VALUES (? , ?)";
        PreparedStatement statement = mySQLConnection.prepareStatement(sql2);
        statement.setString(1,name);
        statement.setString(2,diameter);
        System.out.println(statement.executeUpdate());

        ArrayList<String> data = new ArrayList<>();

        if (type.equals("galaxies")) {
            galaxies = new ArrayList<>();
        }
        else if(type.equals("stars")){
            stars = new ArrayList<>();
        }
        else if(type.equals("planets")){
            planets = new ArrayList<>();
        }
        statement.close();
        mySQLConnection.connection.close();
    }*/
}
