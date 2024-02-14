package main.model.motionless;

import main.model.Coordinates;
import main.model.Entity;

public class Rock extends Entity {
    private static final String imageOfRock = "\uD83C\uDFD4";

    public Rock(Coordinates coordinates) {
        super(coordinates, imageOfRock);
    }
}
