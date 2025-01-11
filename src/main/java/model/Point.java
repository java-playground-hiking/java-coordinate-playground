package model;

import messages.ErrorMessages;

import java.util.Objects;

public class Point {
    private static final int MAX_COORDINATE = 24;
    private static final int MIN_COORDINATE = 0;
    private static final int X_PADDING = 3;

    private int x;
    private int y;

    public Point(){}

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        validateRange();
    }

    public static Point of(int x, int y){
        return new Point(x, y);
    }


    public void validateRange(){
        if (!isCorrectRange(x) || !isCorrectRange(y)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_RANGE);
        }
    }

    public boolean isCorrectRange(int value){
        return value <= MAX_COORDINATE && value >= MIN_COORDINATE;
    }

    public double minusX(Point other) {
        return x - other.x;
    }

    public double minusY(Point other) {
        return y - other.y;
    }

    public void drawPoint(StringBuilder[] graph){
        graph[MAX_COORDINATE - y].setCharAt(x * X_PADDING, '●');
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
