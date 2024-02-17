package main.model.dynamic;

import main.model.*;


public class Herbivore extends Creature {

    private static final String imageOfSheep = "\uD83D\uDC11";

    public Herbivore(Coordinates coordinates) {
        super(coordinates, imageOfSheep);
    }

    @Override
    public void makeMove(Board board) {
        pathToTarget = Actions.findPath(coordinates, "Grass");
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
