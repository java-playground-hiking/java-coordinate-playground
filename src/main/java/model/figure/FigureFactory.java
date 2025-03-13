package model.figure;

import java.util.Arrays;
import model.coordinate.Coordinates;
import model.point.Points;

public enum FigureFactory {

    LINE(2) {
        @Override
        public Figure createFigure(Points points) {
            return Line.from(points);
        }
    },
    TRIANGLE(3) {
        @Override
        public Figure createFigure(Points points) {
            return Triangle.from(points);
        }
    },
    RECTANGLE(4) {
        @Override
        public Figure createFigure(Points points) {
            return Rectangle.from(points);
        }
    };

    private final int figureSize;

    FigureFactory(int figureSize) {
        this.figureSize = figureSize;
    }

    public abstract Figure createFigure(Points points);

    public static Figure create(Coordinates coordinates) {
        return Arrays.stream(values())
                .filter(type -> coordinates.isEqualSize(type.figureSize))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .createFigure(coordinates.toPoints());
    }




}
