package main.model;

import main.model.dynamic.Herbivore;
import main.model.dynamic.Predator;
import main.model.motionless.Grass;
import main.model.motionless.Rock;
import main.model.motionless.Tree;

public class Actions {

    private final Integer amountOfRocks = 30;
    private final Integer amountOfGrass = 15;
    private final Integer amountOfTrees = 20;
    private final Integer amountOfHerbivores = 5;
    private final Integer amountOfPredators = 2;
    private final Board board;

    public Actions(Board board) {
        this.board = board;
    }

    public void initActions() {
        Integer mapHeight = board.getHeight();
        Integer mapWidth = board.getWidth();
        for (int i = 0; i < amountOfRocks; i++) {
            int height = (int) (Math.random() * mapHeight);
            int width = (int) (Math.random() * mapWidth);
            Coordinates coordinates = new Coordinates(width, height);
            if (board.isCoordinateEmpty(coordinates)) {
                board.addEntityOnMap(coordinates, new Rock(coordinates));
            }
        }
        for (int i = 0; i < amountOfTrees; i++) {
            int height = (int) (Math.random() * mapHeight);
            int width = (int) (Math.random() * mapWidth);
            Coordinates coordinates = new Coordinates(width, height);
            if (board.isCoordinateEmpty(coordinates)) {
                board.addEntityOnMap(coordinates, new Tree(coordinates));
            }
        }
        for (int i = 0; i < amountOfGrass; i++) {
            int height = (int) (Math.random() * mapHeight);
            int width = (int) (Math.random() * mapWidth);
            Coordinates coordinates = new Coordinates(width, height);
            if (board.isCoordinateEmpty(coordinates)) {
                board.addEntityOnMap(coordinates, new Grass(coordinates));
            }
        }
        for (int i = 0; i < amountOfHerbivores; i++) {
            boolean flag = false;
            do {
                int height = (int) (Math.random() * mapHeight);
                int width = (int) (Math.random() * mapWidth);
                Coordinates coordinates = new Coordinates(width, height);
                flag = board.isCoordinateEmpty(coordinates);
                if (flag) {
                    board.addEntityOnMap(coordinates, new Herbivore(coordinates));
                }

            } while (!flag);
        }
        for (int i = 0; i < amountOfPredators; i++) {
            boolean flag = false;
            do {
                int height = (int) (Math.random() * mapHeight);
                int width = (int) (Math.random() * mapWidth);
                Coordinates coordinates = new Coordinates(width, height);
                flag = board.isCoordinateEmpty(coordinates);
                if (flag) {
                    board.addEntityOnMap(coordinates, new Predator(coordinates));
                }

            } while (!flag);
        }
    }

    public void turnActions() {

    }

    private void nextTurn() {
        //todo next turn
    }

    public void startSimulation() {
        //todo start simulation
    }

    public void pauseSimulation() {
        //todo pause simulation
    }
}
