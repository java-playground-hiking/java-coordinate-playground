package coordinate.figure;

import coordinate.point.Point;
import coordinate.point.Points;
import java.util.List;

public class Rectangle implements Figure {

    private final Points points;

    private Rectangle(Points points) {
        this.points = points;
    }

    public static Rectangle from(Points points) {
        return new Rectangle(points);
    }

    @Override
    public boolean isMark(int x, int y) {
        return points.isMarkedAt(x, y);
    }

    @Override
    public String toString() {
        return "사각형의 넓이는 " + (int) calculate();
    }

    /**
     * width * height
     */
    @Override
    public double calculate() {
        List<Point> points = this.points.getPoints();

        Point leftBottomPoint = getLeftBottomPoint(points);
        Point rightTopPoint = getRightTopPoint(points);

        return getWidth(leftBottomPoint, rightTopPoint) * getHeight(leftBottomPoint, rightTopPoint);
    }

    private Point getLeftBottomPoint(List<Point> points) {
        return points.get(0);
    }

    private static Point getRightTopPoint(List<Point> points) {
        return points.get(2);
    }

    private double getWidth(Point point1, Point point2) {
        return Math.abs(point1.subtractionByX(point2));
    }

    private double getHeight(Point point1, Point point2) {
        return Math.abs(point1.subtractionByY(point2));
    }

}
