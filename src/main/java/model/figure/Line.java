package model.figure;

import java.util.Objects;
import model.point.Points;

public class Line implements Figure {

    private static final int POINTS_SIZE = 2;
    private final Points points;

    public Line(Points points) {
        if (doesNotTwoPoints(points)) {
            throw new IllegalArgumentException("2개의 좌표만 입력할 수 있습니다.");
        }
        this.points = points;
    }

    private boolean doesNotTwoPoints(Points points) {
        return !points.isEqualSize(POINTS_SIZE);
    }

    public static Line from(Points points) {
        return new Line(points);
    }

    @Override
    public double calculate() {
        return points.calculateDistance().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    @Override
    public String toString() {
        return String.format("두 점 사이의 거리는 %.6f", calculate());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
