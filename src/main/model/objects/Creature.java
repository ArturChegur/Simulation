package main.model.objects;

import main.model.map.Board;
import main.model.map.Coordinates;

import java.util.Stack;


public abstract class Creature extends Entity {
    protected Stack<Coordinates> pathToTarget = new Stack<>();
    protected Integer health = 100;

    protected Creature(Coordinates coordinates, String image) {
        super(coordinates, image);
    }

    public abstract void makeMove(Board board);
}
