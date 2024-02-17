package main.model;

import main.model.dynamic.Herbivore;
import main.model.dynamic.Predator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Simulation {
    private static final BoardRender boardRender;
    private static Integer numberOfIterations = 40;
    private static final Actions actions;
    private static final Board board;
    private static boolean flag = true;

    static {
        board = new Board();
        boardRender = new BoardRender(board);
        actions = new Actions(board);
    }

    public static void main(String[] args) throws InterruptedException {
        startSimulation();
    }

    private static void startSimulation() throws InterruptedException {
        actions.placeEntities();
//        while (flag) {
//            nextTurn();
//        }
        for (int i = 0; i < numberOfIterations; i++) {
            nextTurn();
        }
    }

    private static void nextTurn() throws InterruptedException {
        List<Entity> entitiesOnBoard = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry : board.getMap().entrySet()) {
            Entity entity = entry.getValue();
            if (entity instanceof Herbivore || entity instanceof Predator) {
                entitiesOnBoard.add(entity);
            }
        }
        for (Entity entity : entitiesOnBoard) {
            ((Creature) entity).makeMove(board);
        }
        boardRender.render(board);
        Thread.sleep(700);
        System.out.println("new");
    }
}
