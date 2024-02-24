package main.objects.dynamic;

import main.map.Board;
import main.Simulation;
import main.algorithm.BFSPathFinder;
import main.map.Coordinates;
import main.objects.Creature;


public class Predator extends Creature {
    private static final String IMAGE_OF_PREDATOR = "\uD83D\uDC05";
    private final Integer damage = 40;

    public Predator(Coordinates coordinates) {
        super(coordinates, IMAGE_OF_PREDATOR);
    }

    @Override
    public void makeMove(Board board) {
        pathToTarget = BFSPathFinder.getPath(coordinates, Herbivore.class, Predator.class, board);
        if (pathToTarget != null) {
            Coordinates newCoordinates = pathToTarget.pop();
            Herbivore herbivore = (Herbivore) board.getEntity(newCoordinates);
            if (herbivore != null) {
                herbivore.reduceHealth(damage);
                if (herbivore.getHealth() <= 0) {
                    board.removeEntity(coordinates);
                    coordinates = newCoordinates;
                    board.addEntityOnMap(newCoordinates, this);
                }
            } else {
                board.removeEntity(coordinates);
                coordinates = newCoordinates;
                board.addEntityOnMap(newCoordinates, this);
            }
            Simulation.pauseSimulation(false);
        }
    }
}
