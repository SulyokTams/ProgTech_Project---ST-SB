package hu.progtech.bead;

public class Galaxy extends CelestialBody {
    public String numberOfStars;

    public Galaxy(String id, String name, String diameter, String mass, String numberOfStars, String universe_id) {
        this.id = id;
        this.name = name;
        this.diameter = diameter;
        this.mass = mass;
        this.numberOfStars = numberOfStars;
        this.universe_id = universe_id;
    }
}
