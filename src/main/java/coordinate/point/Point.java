package coordinate.point;

import coordinate.exception.CoordinateException;
import coordinate.messages.ErrorMessage;
import java.util.Objects;

public class Point {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 24;
    private final int x;
    private final int y;

    private Point(int x, int y) {
        if (validateInputValue(x) || validateInputValue(y)) {
            throw new CoordinateException(ErrorMessage.invalidPoint);
        }

        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public boolean isMark(int x, int y) {
        return this.x == x && this.y == y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private boolean validateInputValue(int point) {
        return point < MIN_VALUE || point > MAX_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
