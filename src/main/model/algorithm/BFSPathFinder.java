package main.model.algorithm;

import main.model.map.Board;
import main.model.map.Coordinates;
import main.model.objects.Entity;
import main.model.objects.dynamic.Herbivore;

import java.util.*;


public class BFSPathFinder {
    private static final int[][] DIRECTIONS_FOR_SHIFT = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static Stack<Coordinates> getPath(Coordinates coordinates, Class<? extends Entity> target, Class<? extends Entity> searcher, Board board) {
        Queue<Coordinates> queueOfCoordinates = new LinkedList<>();
        HashMap<Coordinates, Coordinates> previousCoordinates = new HashMap<>();
        queueOfCoordinates.add(coordinates);
        HashSet<Coordinates> visited = new HashSet<>();
        visited.add(coordinates);
        while (!queueOfCoordinates.isEmpty()) {
            Coordinates current = queueOfCoordinates.poll();
            Entity entity = board.getEntity(current);
            if (entity != null && (entity.getClass()).equals(target)) {
                return findPath(previousCoordinates, current);
            }
            int currentHeight = current.getHeightCoordinate();
            int currentWidth = current.getWidthCoordinate();
            int numberForDirectionsOfShift = 4;
            if ((Herbivore.class.equals(target))) {
                numberForDirectionsOfShift = 8;
            }
            for (int i = 0; i < numberForDirectionsOfShift; i++) {
                int newWidth = currentWidth + DIRECTIONS_FOR_SHIFT[i][0];
                int newHeight = currentHeight + DIRECTIONS_FOR_SHIFT[i][1];
                Coordinates neighbor = new Coordinates(newWidth, newHeight);
                if (isCoordinateValidForCreature(neighbor, target, board) && !visited.contains(neighbor)) {
                    queueOfCoordinates.add(neighbor);
                    visited.add(neighbor);
                    previousCoordinates.put(neighbor, current);
                }
            }
        }
        return null;
    }

    private static boolean isCoordinateValidForCreature(Coordinates coordinates, Class<? extends Entity> target, Board board) {
        int height = coordinates.getHeightCoordinate();
        int width = coordinates.getWidthCoordinate();
        Entity entity = board.getEntity(coordinates);
        if (entity != null) {
            return target.equals(entity.getClass());
        }
        return (board.getWidth() > width && width >= 0) && (board.getHeight() > height && height >= 0);
    }

    private static Stack<Coordinates> findPath(HashMap<Coordinates, Coordinates> previousCoordinates, Coordinates current) {
        Stack<Coordinates> path = new Stack<>();
        while (current != null) {
            path.add(current);
            current = previousCoordinates.get(current);
        }
        path.pop();
        return path;
    }
}