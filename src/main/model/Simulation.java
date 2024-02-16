package main.model;

public class Simulation {
    private static BoardRender boardRender;
    private static Integer numberOfIterations = 10;
    private static final Actions actions;
    private static final Board board;

    static {
        board = new Board();
        boardRender = new BoardRender(board);
        actions = new Actions(board, boardRender, numberOfIterations);
    }

    public static void main(String[] args) throws InterruptedException {
        actions.placeEntities();
        actions.startSimulation();

    }
}
