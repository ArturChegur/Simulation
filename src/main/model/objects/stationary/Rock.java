package main.model.objects.stationary;

import main.model.map.Coordinates;
import main.model.objects.Entity;


public class Rock extends Entity {
    private static final String IMAGE_OF_ROCK = "\uD83C\uDFD4";

    public Rock(Coordinates coordinates) {
        super(coordinates, IMAGE_OF_ROCK);
    }
}
