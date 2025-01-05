package coordinate.figure;

import coordinate.point.Point;
import coordinate.point.Points;
import java.util.List;

public class Line implements Figure {

    private final Points points;

    private Line(Points points) {
        this.points = points;
    }

    public static Line from(Points points) {
        return new Line(points);
    }

    @Override
    public String toString() {
        return String.format("두 점 사이의 거리는: " + calculate());
    }

    @Override
    public boolean isMark(int x, int y) {
        return points.isMarkedAt(x, y);
    }

    /**
     * 제곱근((A.x - B.x)^제곱 + (A.y - B.y)^제곱)
     */
    @Override
    public double calculate() {
        List<Point> points = this.points.getPoints();

        Point firstPoint = getFirstPoint(points);
        Point secondPoint = getSecondPoint(points);

        return calculateDistanceBetweenPoints(firstPoint, secondPoint);
    }

    private Point getFirstPoint(List<Point> points) {
        return points.get(0);
    }

    private Point getSecondPoint(List<Point> points) {
        return points.get(1);
    }

    private double calculateDistanceBetweenPoints(Point point1, Point point2) {
        double subX = square(point1.subtractionByX(point2));
        double subY = square(point1.subtractionByY(point2));
        return Math.sqrt(subX + subY);
    }

    private double square(int value) {
        return Math.pow(value, 2);
    }
}
