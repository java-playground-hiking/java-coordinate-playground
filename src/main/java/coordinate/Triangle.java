package coordinate;

import java.util.List;

public class Triangle extends AbstractFigure{
    public static final int TRIANGLE_POINT_SIZE = 3;

    public Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public int size() {
        return TRIANGLE_POINT_SIZE;
    }

    @Override
    public String getName() {
        return "삼각형";
    }

    @Override
    public double area() {
        return 0;
    }
}
