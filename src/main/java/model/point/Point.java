package model.point;

import java.util.Objects;
import model.coordinate.Coordinate;

public class Point {

    private final Coordinate coordinate;

    private Point(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public static Point of(Coordinate coordinate) {
        return new Point(coordinate);
    }

    public double distanceTo(Point other) {
        int deltaX = getDeltaX(other);
        int deltaY = getDeltaY(other);

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public int getDeltaX(Point other) {
        return coordinate.getDeltaX(other.coordinate);
    }

    public int getDeltaY(Point other) {
        return coordinate.getDeltaY(other.coordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Objects.equals(coordinate, point.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinate);
    }

}
