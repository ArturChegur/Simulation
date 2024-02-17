package main.model;

import main.model.dynamic.Herbivore;
import main.model.dynamic.Predator;
import main.model.motionless.Grass;
import main.model.motionless.Rock;
import main.model.motionless.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Actions {
    private final Integer amountOfRocks = 20;//30;
    private final Integer amountOfGrass = 220;//15;
    private final Integer amountOfTrees = 30;//20;
    private final Integer amountOfHerbivores = 10;//5;
    private final Integer amountOfPredators = 0;//2;
    private static Board board;

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // remake order


    public Actions(Board board) {
        Actions.board = board;
    }

    public void placeEntities() {
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
            boolean flag;
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
            boolean flag;
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

    public static Coordinates findPath(Coordinates coordinates, String target) {
        Queue<Coordinates> queueOfCoordinates = new LinkedList<>();
        HashMap<Coordinates, Coordinates> previousCoordinates = new HashMap<>();
        queueOfCoordinates.add(coordinates);
        HashSet<Coordinates> visited = new HashSet<>();
        visited.add(coordinates);
        while (!queueOfCoordinates.isEmpty()) {
            Coordinates current = queueOfCoordinates.poll();
            Entity entity = board.getEntity(current);
            if (entity != null && entity.getClass().getSimpleName().equals(target)) {
                LinkedList<Coordinates> path = new LinkedList<>();
                while (current != null) {
                    path.addFirst(current);
                    current = previousCoordinates.get(current);
                }
                return path.get(1);
            }
            int currentHeight = current.getHeightCoordinate();
            int currentWidth = current.getWidthCoordinate();
            for (int[] dir : directions) {
                int newWidth = currentWidth + dir[0];
                int newHeight = currentHeight + dir[1];
                Coordinates neighbor = new Coordinates(newWidth, newHeight);
                if (isValid(neighbor, target) && !visited.contains(neighbor)) {
                    queueOfCoordinates.add(neighbor);
                    visited.add(neighbor);
                    previousCoordinates.put(neighbor, current);
                }
            }
        }
        return null;
    }

    private static boolean isValid(Coordinates coordinates, String target) {
        int height = coordinates.getHeightCoordinate();
        int width = coordinates.getWidthCoordinate();
        Entity entity = board.getEntity(coordinates);
        if (entity instanceof Rock || entity instanceof Tree) {
            return false;
        } else if (target.equals("Grass") && (entity instanceof Predator || entity instanceof Herbivore)) {
            return false;
        } else if (target.equals("Herbivore") && entity instanceof Predator) {
            return false;
        }
        return (board.getWidth() > width && width >= 0) && (board.getHeight() > height && height >= 0);
    }
}
