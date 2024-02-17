package main.model.dynamic;

import main.model.Board;
import main.model.Coordinates;
import main.model.Creature;
import main.model.Entity;

import java.util.HashMap;

public class Predator extends Creature {
    private static final String imageOfPredator = "\uD83D\uDC05";
    private Integer damage;

    public Predator(Coordinates coordinates) {
        super(coordinates, imageOfPredator);
    }

    @Override
    public void makeMove(Board board) {


    }
}
