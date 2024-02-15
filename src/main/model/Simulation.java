package main.model;

public class Simulation {
    private static BoardRender boardRender;
    private Integer iterationCounter = 0;
    private static final Actions actions;
    private static final Board board;

    static {
        board = new Board();
        boardRender = new BoardRender(board);
        actions = new Actions(board);
    }

    public static void main(String[] args) throws InterruptedException {
        actions.initActions();
        actions.startSimulation();
        boardRender.render(board);
    }

    private static void startSimulation() {

    }
}
