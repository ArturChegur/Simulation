package main.objects.stationary;

import main.map.Coordinates;
import main.objects.Entity;


public class Rock extends Entity {
    private static final String IMAGE_OF_ROCK = "\uD83C\uDFD4";

    public Rock(Coordinates coordinates) {
        super(coordinates, IMAGE_OF_ROCK);
    }
}
