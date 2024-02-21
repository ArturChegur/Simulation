package main.model.objects.stationary;

import main.model.map.Coordinates;
import main.model.objects.Entity;


public class Grass extends Entity {
    private static final String IMAGE_OF_GRASS = "\uD83C\uDF31";

    public Grass(Coordinates coordinates) {
        super(coordinates, IMAGE_OF_GRASS);
    }
}
