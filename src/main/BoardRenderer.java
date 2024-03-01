package main;

import main.map.Board;
import main.map.Coordinates;

public class BoardRenderer {
    public static void render(Board board) {
        int boardHeight = board.getHeight();
        int boardWidth = board.getWidth();
        StringBuilder line = new StringBuilder();
        for (int height = 0; height < boardHeight; height++) {
            for (int width = 0; width < boardWidth; width++) {
                Coordinates currentCoordinate = new Coordinates(width, height);
                if (board.isCoordinateEmpty(currentCoordinate)) {
                    line.append(" . ");
                } else {
                    line.append(board.getEntity(currentCoordinate).getImage()).append(" ");
                }
            }
            line.append("\n");
        }
        System.out.println(line);
    }
}
