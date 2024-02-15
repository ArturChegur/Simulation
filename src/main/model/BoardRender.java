package main.model;

public class BoardRender {
    private final Integer boardHeight;
    private final Integer boardWidth;

    public BoardRender(Board board) {
        boardHeight = board.getHeight();
        boardWidth = board.getWidth();
    }

    public void render(Board board) {
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
