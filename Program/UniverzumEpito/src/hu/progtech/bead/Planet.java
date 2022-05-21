package hu.progtech.bead;

public class Planet {
    public Planet(String id, String name, String diameter, String mass, String orbitalPeriod, String universe_id) {
        this.id = id;
        this.name = name;
        this.diameter = diameter;
        this.mass = mass;
        this.orbitalPeriod = orbitalPeriod;
        this.universe_id = universe_id;
    }

    public String id;
    public String name;
    public String diameter;
    public String mass;
    public String orbitalPeriod;
    public String universe_id;
}
