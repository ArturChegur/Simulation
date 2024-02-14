package main.model;


import java.util.Objects;

public class Coordinates {
    private final Integer CoordinateByX;
    private final Integer CoordinateByY;

    public Coordinates(Integer CoordinateByX, Integer CoordinateByY) {
        this.CoordinateByX = CoordinateByX;
        this.CoordinateByY = CoordinateByY;
    }

    public Integer getCoordinateByX() {
        return CoordinateByX;
    }

    public Integer getCoordinateByY() {
        return CoordinateByY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(CoordinateByX, that.CoordinateByX) && Objects.equals(CoordinateByY, that.CoordinateByY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CoordinateByX, CoordinateByY);
    }
}
