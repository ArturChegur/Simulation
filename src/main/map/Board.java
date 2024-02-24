package main.map;

import main.objects.Creature;
import main.objects.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Board {
    private static final Integer HEIGHT = 20;
    private static final Integer WIDTH = 20;
    private final HashMap<Coordinates, Entity> map = new HashMap<>();

    public void addEntityOnMap(Coordinates coordinates, Entity entity) {
        map.put(coordinates, entity);
    }

    public Integer getHeight() {
        return HEIGHT;
    }

    public Integer getWidth() {
        return WIDTH;
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
    }

    public List<Creature> getAllEntitiesOnMap() {
        List<Creature> entities = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            Entity entity = entry.getValue();
            if (entity instanceof Creature) {
                entities.add((Creature) entity);
            }
        }
        return entities;
    }
}
