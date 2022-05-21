package hu.progtech.bead;

public class Planet extends CelestialBody {
    public String orbitalPeriod;

    public Planet(String id, String name, String diameter, String mass, String orbitalPeriod, String universe_id) {
        this.id = id;
        this.name = name;
        this.diameter = diameter;
        this.mass = mass;
        this.orbitalPeriod = orbitalPeriod;
        this.universe_id = universe_id;
    }

}
