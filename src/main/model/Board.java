package main.model;

import java.util.HashMap;


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

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }
}
