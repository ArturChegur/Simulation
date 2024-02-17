package main.model.motionless;

import main.model.Coordinates;
import main.model.Entity;


public class Tree extends Entity {
    private static final String imageOfTree = "\uD83C\uDF32";

    public Tree(Coordinates coordinates) {
        super(coordinates, imageOfTree);
    }
}
