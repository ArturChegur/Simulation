package main.model;

import main.model.dynamic.Herbivore;
import main.model.dynamic.Predator;
import main.model.motionless.Grass;
import main.model.motionless.Rock;
import main.model.motionless.Tree;

import java.util.*;


public final class Actions {
    private static final Integer amountOfRocks = 50;
    private static final Integer amountOfGrass = 100;
    private static final Integer amountOfTrees = 30;
    private static final Integer amountOfHerbivores = 15;
    private static final Integer amountOfPredators = 3;
    private static final int[][] directionsForPredator = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private static final int[][] directionsForHerbivore = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static Board board;

    public static void setBoard(Board board) {
        Actions.board = board;
    }

    public static void placeEntities() {
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

    public static Stack<Coordinates> findPath(Coordinates coordinates, String target) {
        Queue<Coordinates> queueOfCoordinates = new LinkedList<>();
        HashMap<Coordinates, Coordinates> previousCoordinates = new HashMap<>();
        queueOfCoordinates.add(coordinates);
        HashSet<Coordinates> visited = new HashSet<>();
        visited.add(coordinates);
        while (!queueOfCoordinates.isEmpty()) {
            Coordinates current = queueOfCoordinates.poll();
            Entity entity = board.getEntity(current);
            if (entity != null && entity.getClass().getSimpleName().equals(target)) {
                Stack<Coordinates> path = new Stack<>();
                while (current != null) {
                    path.add(current);
                    current = previousCoordinates.get(current);
                }
                path.pop();
                return path;
            }
            int currentHeight = current.getHeightCoordinate();
            int currentWidth = current.getWidthCoordinate();
            if (target.equals("Herbivore")) {
                for (int[] dir : directionsForPredator) {
                    int newWidth = currentWidth + dir[0];
                    int newHeight = currentHeight + dir[1];
                    Coordinates neighbor = new Coordinates(newWidth, newHeight);
                    if (isValid(neighbor, target) && !visited.contains(neighbor)) {
                        queueOfCoordinates.add(neighbor);
                        visited.add(neighbor);
                        previousCoordinates.put(neighbor, current);
                    }
                }
            } else {
                for (int[] dir : directionsForHerbivore) {
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
        }
        return null;
    }

    private static boolean isValid(Coordinates coordinates, String target) {
        int height = coordinates.getHeightCoordinate();
        int width = coordinates.getWidthCoordinate();
        Entity entity = board.getEntity(coordinates);
        if (entity instanceof Rock || entity instanceof Tree || entity instanceof Predator) {
            return false;
        } else if (target.equals("Grass") && entity instanceof Herbivore) {
            return false;
        } else if (target.equals("Herbivore") && entity instanceof Grass) {
            return false;
        }
        return (board.getWidth() > width && width >= 0) && (board.getHeight() > height && height >= 0);
    }

    public static void spawnGrass(Integer amountOfGrass) {
        for (int i = 0; i < amountOfGrass; i++) {
            int height = (int) (Math.random() * board.getHeight());
            int width = (int) (Math.random() * board.getWidth());
            Coordinates coordinates = new Coordinates(width, height);
            if (board.isCoordinateEmpty(coordinates)) {
                board.addEntityOnMap(coordinates, new Grass(coordinates));
            }
        }
    }
}
