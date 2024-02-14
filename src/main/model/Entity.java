package main.model;

public abstract class Entity {
    protected Coordinates coordinates;
    private final String image;

    protected Entity(Coordinates coordinates, String image) {
        this.coordinates = coordinates;
        this.image = image;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getImage() {
        return image;
    }
}
