package main.model;

import main.model.map.Board;
import main.model.map.Coordinates;

public class BoardRenderer {
    public static void render(Board board) {
        int boardHeight = board.getHeight();
        int boardWidth = board.getWidth();
        for (int height = 0; height < boardHeight; height++) {
            StringBuilder line = new StringBuilder();
            for (int width = 0; width < boardWidth; width++) {
                Coordinates currentCoordinate = new Coordinates(width, height);
                if (board.isCoordinateEmpty(currentCoordinate)) {
                    line.append(" . ");
                } else {
                    line.append(board.getEntity(currentCoordinate).getImage()).append(" ");
                }
            }
            System.out.println(line);
        }
    }
}
