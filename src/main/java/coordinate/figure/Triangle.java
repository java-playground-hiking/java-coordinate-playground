package coordinate.figure;

import coordinate.point.Point;
import coordinate.point.Points;
import java.util.ArrayList;
import java.util.List;

public class Triangle implements Figure{

    private final Points points;

    private Triangle(Points points) {
        this.points = points;
    }

    public static Triangle from(Points points) {
        return new Triangle(points);
    }

    @Override
    public boolean isMark(int x, int y) {
        return points.isMarkedAt(x, y);
    }

    @Override
    public String toString() {
        return "삼각형의 넓이는 " + (double) Math.round(calculate());
    }

    @Override
    public double calculate() {
        List<Double> distances = getDistances();
        double half = getHalf(distances);
        return getTriangleWidthByDistances(distances, half);
    }

    private List<Double> getDistances() {
        List<Point> pointsArray = points.getPoints();
        List<Double> distances = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            int nextIndex = getPointNextIndex(i);
            distances.add(getPointsBetweenDistance(pointsArray.get(i), pointsArray.get(nextIndex)));
        }

        return distances;
    }

    private int getPointNextIndex(int index) {
        int pointSize = points.size();

        if (index == pointSize-1) {
            return 0;
        }

        return index + 1;
    }

    private double getPointsBetweenDistance(Point point1, Point point2) {
        Line line = Line.from(Points.from(List.of(point1, point2)));
        return line.calculate();
    }

    private double getHalf(List<Double> distances) {
        return distances.stream().mapToDouble(Double::doubleValue).sum() / 2;
    }

    private double getTriangleWidthByDistances(List<Double> distances, double half) {
        double width = 1;
        for (double distance : distances) {
            width *= (half - distance);
        }
        width *= half;

        return Math.sqrt(width);
    }

}
