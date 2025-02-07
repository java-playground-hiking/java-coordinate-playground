package model;

import validator.FigureValidator;

import java.util.Objects;

public class Point {
    private static final int MAX_COORDINATE = 24;
    private static final int X_PADDING = 3;

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y){
        FigureValidator.validateRange(x, y);

        return new Point(x, y);
    }


    public int minusX(Point other){
        return this.x - other.x;
    }

    public int minusY(Point other){
        return this.y - other.y;
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
