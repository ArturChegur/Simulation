package main.model.actions;


import main.model.map.Board;
import main.model.map.Coordinates;
import main.model.objects.dynamic.Herbivore;
import main.model.objects.dynamic.Predator;
import main.model.objects.stationary.Grass;
import main.model.objects.stationary.Rock;
import main.model.objects.stationary.Tree;


public class Actions {
    public static void placeDefaultEntities(Board board) {
        spawnGrass(80, board);
        spawnRocks(40, board);
        spawnTrees(40, board);
        spawnHerbivores(14, board);
        spawnPredators(2, board);
    }

    public static void spawnHerbivores(Integer amountOfHerbivores, Board board) {
        int boardHeight = board.getHeight();
        int boardWidth = board.getWidth();
        boolean isEntityPlaced;
        for (int i=0; i < amountOfHerbivores ; i++) {
            isEntityPlaced = false;
            while (!isEntityPlaced) {
                int height = (int) (Math.random() * boardHeight);
                int width = (int) (Math.random() * boardWidth);
                Coordinates coordinates = new Coordinates(width, height);
                if (board.isCoordinateEmpty(coordinates)) {
                    board.addEntityOnMap(coordinates, new Herbivore(coordinates));
                    isEntityPlaced = true;
                }
            }
        }
    }

    public static void spawnPredators(Integer amountOfPredators, Board board) {
        int boardHeight = board.getHeight();
        int boardWidth = board.getWidth();
        boolean isEntityPlaced;
        for (int i=0; i < amountOfPredators ; i++) {
            isEntityPlaced = false;
            while (!isEntityPlaced) {
                int height = (int) (Math.random() * boardHeight);
                int width = (int) (Math.random() * boardWidth);
                Coordinates coordinates = new Coordinates(width, height);
                if (board.isCoordinateEmpty(coordinates)) {
                    board.addEntityOnMap(coordinates, new Predator(coordinates));
                    isEntityPlaced = true;
                }
            }
        }
    }

    public static void spawnTrees(Integer amountOfTrees, Board board) {
        int boardHeight = board.getHeight();
        int boardWidth = board.getWidth();
        for (int i = 0; i < amountOfTrees; i++) {
            int height = (int) (Math.random() * boardHeight);
            int width = (int) (Math.random() * boardWidth);
            Coordinates coordinates = new Coordinates(width, height);
            if (board.isCoordinateEmpty(coordinates)) {
                board.addEntityOnMap(coordinates, new Tree(coordinates));
            }
        }
    }

    public static void spawnRocks(Integer amountOfRocks, Board board) {
        int boardHeight = board.getHeight();
        int boardWidth = board.getWidth();
        for (int i = 0; i < amountOfRocks; i++) {
            int height = (int) (Math.random() * boardHeight);
            int width = (int) (Math.random() * boardWidth);
            Coordinates coordinates = new Coordinates(width, height);
            if (board.isCoordinateEmpty(coordinates)) {
                board.addEntityOnMap(coordinates, new Rock(coordinates));
            }
        }
    }

    public static void spawnGrass(Integer amountOfGrass, Board board) {
        int boardHeight = board.getHeight();
        int boardWidth = board.getWidth();
        for (int i = 0; i < amountOfGrass; i++) {
            int height = (int) (Math.random() * boardHeight);
            int width = (int) (Math.random() * boardWidth);
            Coordinates coordinates = new Coordinates(width, height);
            if (board.isCoordinateEmpty(coordinates)) {
                board.addEntityOnMap(coordinates, new Grass(coordinates));
            }
        }
    }
}
