package main.actions;

import main.map.Coordinates;
import main.objects.Entity;
import main.objects.EntityType;
import main.objects.dynamic.Herbivore;
import main.objects.dynamic.Predator;
import main.objects.stationary.Grass;
import main.objects.stationary.Rock;
import main.objects.stationary.Tree;


public class EntityFactory {
    public static Entity createEntity(EntityType entityType, Coordinates coordinates) {
        return switch (entityType) {
            case GRASS -> new Grass(coordinates);
            case ROCK -> new Rock(coordinates);
            case TREE -> new Tree(coordinates);
            case HERBIVORE -> new Herbivore(coordinates);
            case PREDATOR -> new Predator(coordinates);
        };
    }
}
