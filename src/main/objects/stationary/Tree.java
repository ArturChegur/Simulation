package main.objects.stationary;

import main.map.Coordinates;
import main.objects.Entity;


public class Tree extends Entity {
    private static final String IMAGE_OF_TREE = "\uD83C\uDF32";

    public Tree(Coordinates coordinates) {
        super(coordinates, IMAGE_OF_TREE);
    }
}
