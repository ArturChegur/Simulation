package main.model.map;

import java.util.Objects;


public class Coordinates {
    private final Integer widthCoordinate;
    private final Integer heightCoordinate;

    public Coordinates(Integer widthCoordinate, Integer heightCoordinate) {
        this.widthCoordinate = widthCoordinate;
        this.heightCoordinate = heightCoordinate;
    }

    public Integer getWidthCoordinate() {
        return widthCoordinate;
    }

    public Integer getHeightCoordinate() {
        return heightCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(widthCoordinate, that.widthCoordinate) && Objects.equals(heightCoordinate, that.heightCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(widthCoordinate, heightCoordinate);
    }
}
