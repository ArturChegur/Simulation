package main.model.motionless;

import main.model.Coordinates;
import main.model.Entity;

public class Grass extends Entity {
    private static final String imageOfGrass = "\uD83C\uDF3E";

    public Grass(Coordinates coordinates) {
        super(coordinates, imageOfGrass);
    }
}
