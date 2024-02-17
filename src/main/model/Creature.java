package main.model;

import java.util.Stack;


public abstract class Creature extends Entity {
    protected Stack<Coordinates> pathToTarget = new Stack<>();
    protected Integer health = 100;

    protected Creature(Coordinates coordinates, String image) {
        super(coordinates, image);
    }

    protected abstract void makeMove(Board board);
}
