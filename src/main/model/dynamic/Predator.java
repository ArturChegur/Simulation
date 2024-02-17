package main.model.dynamic;

import main.model.*;


public class Predator extends Creature {
    private static final String imageOfPredator = "\uD83D\uDC05";
    private final Integer damage = 40;

    public Predator(Coordinates coordinates) {
        super(coordinates, imageOfPredator);
    }

    @Override
    public void makeMove(Board board) {
        pathToTarget = Actions.findPath(coordinates, "Herbivore");
        if (pathToTarget != null) {
            Coordinates newCoordinates = pathToTarget.pop();
            Herbivore herbivore = (Herbivore) board.getEntity(newCoordinates);
            if (herbivore != null) {
                herbivore.reduceHealth(damage);
                if (herbivore.getHealth() <= 0 ) {
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
