package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class FigureFactory implements FigureCreator{
    static final HashMap<Integer, Function<List<Point>, Figure>> figures = new HashMap<>();

    static {
        figures.put(Line.LINE_POINT_SIZE, (Line::new));
        figures.put(Triangle.TRIANGLE_POINT_SIZE, Triangle::new);
        figures.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle::new);
    }

    @Override
    public Figure create(List<Point> points) {
        Function<List<Point>, Figure> figure = figures.get(points.size());

        if (figure == null) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }

        return figure.apply(points);

    }

    static Figure getInstance(List<Point> points) {


        if (points.size() == Line.LINE_POINT_SIZE) {
            return new Line(points);
        }

        if (points.size() == Triangle.TRIANGLE_POINT_SIZE) {
            return new Triangle(points);
        }

        if (points.size() == Rectangle.RECTANGLE_POINT_SIZE) {
            return new Rectangle(points);
        }

        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
    }
}
