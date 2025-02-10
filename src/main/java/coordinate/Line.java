package coordinate;

import java.util.List;

public class Line extends AbstractFigure{
    public static final int LINE_POINT_SIZE = 2;

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public int size() {
        return LINE_POINT_SIZE;
    }

    @Override
    public String getName() {
        return "선";
    }

    @Override
    public double area() {
        return 0;
    }
}
