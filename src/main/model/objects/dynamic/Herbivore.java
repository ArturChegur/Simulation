package main.model.objects.dynamic;

import main.model.*;
import main.model.algorithm.BFSPathFinder;
import main.model.map.Board;
import main.model.map.Coordinates;
import main.model.objects.Creature;
import main.model.objects.stationary.Grass;


public class Herbivore extends Creature {

    private static final String IMAGE_OF_SHEEP = "\uD83D\uDC11";

    public Herbivore(Coordinates coordinates) {
        super(coordinates, IMAGE_OF_SHEEP);
    }

    @Override
    public void makeMove(Board board) {
        pathToTarget = BFSPathFinder.getPath(coordinates, Grass.class, Herbivore.class, board);
        if (pathToTarget != null) {
            board.removeEntity(coordinates);
            Coordinates newCoordinates = pathToTarget.pop();
            board.addEntityOnMap(newCoordinates, this);
            coordinates = newCoordinates;
            Simulation.pauseSimulation(false);
        }
    }

    public void reduceHealth(Integer damage) {
        health -= damage;
    }

    public Integer getHealth() {
        return health;
    }
}
