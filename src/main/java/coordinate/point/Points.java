package coordinate.point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Points {

    private final List<Point> points;

    private Points(List<Point> points) {
        this.points = points;
    }

    public static Points from(List<Point> points) {
        return new Points(points);
    }

    public boolean isMarkedAt(int x, int y) {
        return points.stream()
                .anyMatch(point -> point.isSamePosition(x, y));
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Points pointList = (Points) o;
        return Objects.equals(points, pointList.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
