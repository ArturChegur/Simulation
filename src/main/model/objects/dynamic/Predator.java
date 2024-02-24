package main.model.objects.dynamic;

import main.model.Simulation;
import main.model.algorithm.BFSPathFinder;
import main.model.map.Board;
import main.model.map.Coordinates;
import main.model.objects.Creature;


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
