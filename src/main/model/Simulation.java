package main.model;

import main.model.actions.Actions;
import main.model.map.Board;
import main.model.objects.Creature;

import java.util.List;


public class Simulation {
    private static Integer numberOfIterations = 0;
    private static final Board BOARD = new Board();
    private static boolean continueSimulation = true;

    public static void main(String[] args) throws InterruptedException {
        startSimulation();
    }

    private static void startSimulation() throws InterruptedException {
        Actions.placeDefaultEntities(BOARD);
        while (continueSimulation) {
            nextTurn();
        }
    }

    public static void pauseSimulation(Boolean status) {
        continueSimulation = !status;
    }

    private static void nextTurn() throws InterruptedException {
        continueSimulation = false;
        BoardRenderer.render(BOARD);
        List<Creature> entitiesOnBoard = BOARD.getMap();
        for (Creature creature : entitiesOnBoard) {
            if (BOARD.getEntity(creature.getCoordinates()).equals(creature)) {
                creature.makeMove(BOARD);
            }
        }
        if (numberOfIterations % 3 == 0) {
            Actions.spawnGrass(5, BOARD);
        }
        Thread.sleep(900);
        System.out.println("Iteration number: " + numberOfIterations);
        numberOfIterations += 1;
    }
}
