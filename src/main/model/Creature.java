package main.model;

public abstract class Creature extends Entity {
    protected Integer speed;

    protected Creature(Coordinates coordinates, String image) {
        super(coordinates, image);
    }

    protected void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    protected abstract void makeMove();
}
