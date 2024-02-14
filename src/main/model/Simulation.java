package main.model;

import main.model.dynamic.Herbivore;
import main.model.dynamic.Predator;
import main.model.motionless.Grass;
import main.model.motionless.Rock;
import main.model.motionless.Tree;

public class Simulation {
    private static final BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();
    private int iterationCounter;

    public static void main(String[] args) throws InterruptedException {
        Herbivore h = new Herbivore(new Coordinates(4, 6));
        Predator p = new Predator(new Coordinates(6, 6));
        Grass g = new Grass(new Coordinates(1, 1));
        Rock r = new Rock(new Coordinates(2, 2));
        Tree t = new Tree(new Coordinates(3, 3));
        Board board = new Board();
        board.addEntityOnMap(h.getCoordinates(), h);
        board.addEntityOnMap(p.getCoordinates(), p);
        board.addEntityOnMap(g.getCoordinates(), g);
        board.addEntityOnMap(r.getCoordinates(), r);
        board.addEntityOnMap(t.getCoordinates(), t);

        for (int i = 0; i < 8; i++) {
            board.removeEntity(p.getCoordinates());
            p.setCoordinates(new Coordinates(5, i));
            board.addEntityOnMap(p.getCoordinates(), p);
            Thread.sleep(500);
            System.out.println("new iteration");
            boardConsoleRenderer.render(board);
        }

    }

    private void nextTurn() {
        //todo next turn
    }

    private void startSimulation() {
        //todo start simulation
    }

    private void pauseSimulation() {
        //todo pause simulation
    }

}
