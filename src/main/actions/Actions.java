package main.actions;

import main.map.Board;
import main.map.Coordinates;
import main.objects.EntityType;


public class Actions {
    public static void placeDefaultEntities(Board board) {
        spawnAction(80, EntityType.GRASS, board);
        spawnAction(40, EntityType.ROCK, board);
        spawnAction(30, EntityType.TREE, board);
        spawnAction(14, EntityType.HERBIVORE, board);
        spawnAction(2, EntityType.PREDATOR, board);
    }

    public static void spawnAction(Integer amount, EntityType entityType, Board board) {
        int boardHeight = board.getHeight();
        int boardWidth = board.getWidth();
        boolean isEntityPlaced;
        for (int i = 0; i < amount; i++) {
            isEntityPlaced = false;
            while (!isEntityPlaced) {
                int height = (int) (Math.random() * boardHeight);
                int width = (int) (Math.random() * boardWidth);
                Coordinates coordinates = new Coordinates(width, height);
                if (board.isCoordinateEmpty(coordinates)) {
                    board.addEntityOnMap(coordinates, EntityFactory.createEntity(entityType, coordinates));
                    isEntityPlaced = true;
                }
            }
        }
    }
}
