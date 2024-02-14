package main.model.dynamic;

import main.model.Coordinates;
import main.model.Creature;

public class Herbivore extends Creature {

    private static final String imageOfSheep = "\uD83D\uDC11";
    protected Integer health;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, imageOfSheep);
    }

    @Override
    public void makeMove() {

    }
}
