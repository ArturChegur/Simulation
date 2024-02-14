package main.model;

public class BoardConsoleRenderer {
    public void render(Board board) {
        Integer height = board.getHeight();
        Integer width = board.getWidth();
        for (int y = 0; y < height; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < width; x++) {
                if (board.isCoordinateEmpty(new Coordinates(x, y))) {
                    line.append(" . ");
                } else {
                    line.append(board.getEntity(new Coordinates(x, y)).getImage()).append(" ");
                }
            }
            System.out.println(line);
        }
    }
}
