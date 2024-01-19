package main.game;

import java.util.ArrayList;
import java.util.List;

import main.model.Entity;
import main.model.dynamic.Herbivore;
import main.model.dynamic.Predator;

public class Simulation {
    public static void main(String[] args) {
        List<Entity> list = new ArrayList<>();
        list.add(new Predator());
        list.add(new Herbivore());
    }
}
