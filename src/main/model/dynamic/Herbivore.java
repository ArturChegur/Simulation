package main.model.dynamic;

import main.model.*;

import java.util.HashMap;

public class Herbivore extends Creature {

    private static final String imageOfSheep = "\uD83D\uDC11";
    protected Integer health = 100;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, imageOfSheep);
    }

    @Override
    public void makeMove(Board board) {
         Coordinates newCoordinates = Actions.findPath(coordinates, "Grass");
         if (newCoordinates != null) {
             board.removeEntity(coordinates);
             board.addEntityOnMap(newCoordinates, this);
             coordinates = newCoordinates;
         }
    }

    public void reduceHealth(Integer damage) {
        health -= damage;
    }

}
