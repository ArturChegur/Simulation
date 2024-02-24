package main.objects.dynamic;

import main.map.Board;
import main.Simulation;
import main.algorithm.BFSPathFinder;
import main.map.Coordinates;
import main.objects.Creature;
import main.objects.stationary.Grass;


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
