package model.figure;

import java.util.Objects;
import model.point.Point;
import model.point.Points;

public class Rectangle implements Figure {

    private static final int POINTS_SIZE = 4;
    private final Points points;

    public Rectangle(Points points) {
        if (doesNotFourPoints(points)) {
            throw new IllegalArgumentException("사각형은 4개의 좌표로 생성할 수 있습니다.");
        }
        this.points = points;
    }

    public static Rectangle from(Points points) {
        return new Rectangle(points);
    }

    @Override
    public double calculate() {
        Point point1 = points.at(0);
        Point point2 = points.at(2);

        int width = Math.abs(point1.getDeltaX(point2));
        int height = Math.abs(point1.getDeltaY(point2));

        return width * height;
    }

    private boolean doesNotFourPoints(Points points) {
        return !points.isEqualSize(POINTS_SIZE);
    }

    @Override
    public String toString() {
        return String.format("사각형 넓이는 %.0f", calculate());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
