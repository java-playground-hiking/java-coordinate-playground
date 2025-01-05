package coordinate.figure;

import coordinate.exception.CoordinateException;
import coordinate.messages.ErrorMessage;
import coordinate.point.Points;
import java.util.Arrays;

public enum FigureType {
    LINE(2) {
        @Override
        public Figure createFigure(Points points) {
            return Line.from(points);
        }
    },
    RECTANGLE(4) {
        @Override
        public Figure createFigure(Points points) {
            return Rectangle.from(points);
        }
    };

    private final int pointsSize;

    FigureType(int pointsSize) {
        this.pointsSize = pointsSize;
    }

    public abstract Figure createFigure(Points points);

    public static Figure get(FigureSize figureSize) {
        Points points = figureSize.toPoints();

        return Arrays.stream(values())
                .filter(type -> type.pointsSize == points.size())
                .findFirst()
                .orElseThrow(() -> new CoordinateException(ErrorMessage.invalidFigureSize))
                .createFigure(points);
    }
}
