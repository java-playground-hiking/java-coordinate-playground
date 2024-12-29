package coordinate.point;

import java.util.List;
import java.util.Objects;

public class PointList {

    private final List<Point> points;

    private PointList(List<Point> points) {
        this.points = points;
    }

    public static PointList from(List<Point> points) {
        return new PointList(points);
    }

    public boolean isMark(int x, int y) {
        return points.stream()
                .anyMatch(point -> point.isMark(x, y));
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PointList pointList = (PointList) o;
        return Objects.equals(points, pointList.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
