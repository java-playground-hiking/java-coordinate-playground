package model;

import exception.CoordinateException;
import exception.ErrorMessages;

import java.util.Objects;

public class Point {
    private static final int MAX_COORDINATE = 24;
    private static final int MIN_COORDINATE = 0;
    private int x;
    private int y;

    public Point(){}

    public Point(int x, int y){
        validateRange(x, y);
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y){
        return new Point(x, y);
    }

    public void validateRange(int x, int y) {
        if (!isCorrectRange(x) || !isCorrectRange(y)){
            throw new CoordinateException(ErrorMessages.OVER_NUMBER);
        }
    }

    public boolean isCorrectRange(int value) {
        return value <= MAX_COORDINATE && value >= MIN_COORDINATE;
    }

    public int minusX(Point other){
        return this.x - other.x;
    }

    public int minusY(Point other){
        return this.y - other.y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
