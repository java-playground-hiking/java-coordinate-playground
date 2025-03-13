package model.coordinate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import model.point.Points;

public class Coordinates {

    private final List<Coordinate> coordinates;

    private Coordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public static Coordinates from(List<Coordinate> coordinates) {
        return new Coordinates(coordinates);
    }

    public boolean isEqualSize(int figureSize) {
        return this.coordinates.size() == figureSize;
    }

    public Points toPoints() {
        return Points.from(coordinates.stream()
                .map(Coordinate::toPoint)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinates that = (Coordinates) o;
        return Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinates);
    }

}
