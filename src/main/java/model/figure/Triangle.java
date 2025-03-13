package model.figure;

import java.util.List;
import java.util.Objects;
import model.point.Points;

public class Triangle implements Figure {

    private static final int POINTS_SIZE = 3;
    private final Points points;

    private Triangle(Points points) {
        if (doesNotThreePoints(points)) {
            throw new IllegalArgumentException("삼각형은 3개의 좌표로 생성할 수 있습니다.");
        }

        this.points = points;
    }

    public static Triangle from(Points points) {
        return new Triangle(points);
    }

    @Override
    public double calculate() {
        List<Double> pointDistances = points.calculateDistance();

        double half = pointDistances.stream().mapToDouble(Double::doubleValue).sum() / 2;

        double width = half * pointDistances.stream()
                .mapToDouble(distance -> half - distance)
                .reduce(1.0, (a, b) -> a * b);

        return Math.round(
                Math.sqrt(width)
        );
    }

    private boolean doesNotThreePoints(Points points) {
        return !points.isEqualSize(POINTS_SIZE);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Objects.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
