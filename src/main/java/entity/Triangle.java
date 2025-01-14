package entity;

import validation.TriangleValidator;

import java.util.List;

public class Triangle extends Shape {
    private final Point point1;
    private final Point point2;
    private final Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public static Triangle fromPoints(List<Point> points) {
        TriangleValidator.validate(points); // 유효성 검사
        return new Triangle(points.get(0), points.get(1), points.get(2));
    }

    @Override
    public double calculateArea() {
        double sideA = point1.distanceTo(point2);
        double sideB = point2.distanceTo(point3);
        double sideC = point3.distanceTo(point1);

        // 헤론의 공식: s = (a + b + c) / 2
        double s = (sideA + sideB + sideC) / 2;

        // 면적 = √(s * (s - a) * (s - b) * (s - c))
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}
