package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Simulation {
    private static final BoardRender boardRender;
    private static Integer numberOfIterations = 0;
    private static final Board board;
    private static boolean continueSimulation = true;

    static {
        board = new Board();
        boardRender = new BoardRender(board);
        Actions.setBoard(board);
    }

    public static void main(String[] args) throws InterruptedException {
        startSimulation();
    }

    private static void startSimulation() throws InterruptedException {
        Actions.placeEntities();
        while (continueSimulation) {
            nextTurn();
        }
    }

    public static void pauseSimulation(Boolean status) {
        continueSimulation = !status;
    }

    private static void nextTurn() throws InterruptedException {
        boardRender.render(board);
        List<Entity> entitiesOnBoard = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry : board.getMap().entrySet()) {
            Entity entity = entry.getValue();
            if (entity instanceof Creature) {
                entitiesOnBoard.add(entity);
            }
        }
        continueSimulation = false;
        for (Entity entity : entitiesOnBoard) {
            if (board.getEntity(entity.coordinates).equals(entity)) {
                ((Creature) entity).makeMove(board);
            }
        }
        if (numberOfIterations % 3 == 0) {
            Actions.spawnGrass(5);
        }
        Thread.sleep(300);
        System.out.println("Iteration number: " + numberOfIterations);
        numberOfIterations += 1;
    }
}
