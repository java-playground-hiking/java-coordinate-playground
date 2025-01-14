package entity;

public class Line extends Shape {
    private final Point point1;
    private final Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public double calculateArea() {
        // 직선의 면적은 0
        return 0;
    }
}
