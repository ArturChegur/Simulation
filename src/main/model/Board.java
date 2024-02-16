package main.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private static final Integer HEIGHT = 10;
    private static final Integer WIDTH = 10;
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

    public Map<Coordinates, Entity> getMap() {
        return map;
    }
}
