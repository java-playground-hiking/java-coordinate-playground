package model.point;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

    private final List<Point> points;

    private Points(List<Point> points) {
        this.points = points;
    }

    public static Points from(List<Point> points) {
        return new Points(points);
    }

    public boolean isEqualSize(int pointsSize) {
        return pointsSize == this.points.size();
    }

    public Point at(int index) {
        return points.get(index);
    }

    public List<Double> calculateDistance() {
        if (isEqualSize(2)) {
            return distacneTo(1);
        }

        return distacneTo(points.size());

    }

    private List<Double> distacneTo(int iterSize) {
        return IntStream.range(0, iterSize)
                .mapToObj(i -> points.get(i).distanceTo(
                        points.get(getPointNextIndex(i))
                ))
                .collect(Collectors.toList());
    }

    private int getPointNextIndex(int index) {
        int pointSize = points.size();

        if (index == pointSize - 1) {
            return 0;
        }

        return index + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
