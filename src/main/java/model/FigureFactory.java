package model;

import exception.CoordinateException;
import exception.ErrorMessages;
import utils.CoordinateUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static Map<Integer, Function<Points, Figure>> creator;

    static {
        creator = new HashMap<>();
        creator.put(Line.LINE_POINT_SIZE, Line::from);
        creator.put(Triangle.TRIANGLE_POINT_SIZE, Triangle::from);
        creator.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle::from);
    }

    public Figure create(List<Integer> numbers) {
        Points points = Points.from(numbers);
        Function<Points, Figure> figure = creator.get(points.size());

        if(figure == null){
            throw new CoordinateException(ErrorMessages.INVALID_COORDINATE);
        }

        return figure.apply(points);
    }
}
