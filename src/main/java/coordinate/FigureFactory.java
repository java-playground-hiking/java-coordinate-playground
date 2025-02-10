package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory implements FigureCreator{
    private static final Map<Integer, Function<List<Point>, Figure>> creator;

     static{
         creator = new HashMap<>();
         creator.put(Line.LINE_POINT_SIZE, Line::new);
         creator.put(Triangle.TRIANGLE_POINT_SIZE, Triangle::new);
         creator.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle::new);
    }

    @Override
    public Figure create(List<Point> points) {
        Function<List<Point>, Figure> figure = creator.get(points.size());

        if(figure == null){
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }

        return figure.apply(points);
    }

}