package main.model;

import main.model.dynamic.Herbivore;
import main.model.dynamic.Predator;

public class Simulation {
    private static final BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();
    private int iterationCounter;

    public static void main(String[] args) throws InterruptedException {
        Herbivore h = new Herbivore(new Coordinates(3, 6));
        Predator p = new Predator(new Coordinates(5, 6));
        Board board = new Board();
        board.addEntityOnMap(h.getCoordinates(), h);
        board.addEntityOnMap(p.getCoordinates(), p);

        for (int i = 0; i < 8; i++) {
            board.removeEntity(p.getCoordinates());
            p.setCoordinates(new Coordinates(5, i));
            board.addEntityOnMap(p.getCoordinates(), p);
            Thread.sleep(500);
            //System.out.println("new iteration");
            boardConsoleRenderer.render(board);
        }

    }
}
