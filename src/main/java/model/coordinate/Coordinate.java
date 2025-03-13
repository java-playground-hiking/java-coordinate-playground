package model.coordinate;

import java.util.Objects;
import model.point.Point;

public class Coordinate {

    // UserInput 객체로 받아야함
    // 좌표가 유저 입력 값을 파싱 해서 쓰는건 너무 많은 일을 함
    // 그렇기 때문에 좌표는 좌표 값만 알아야 함
    // 이 때 좌표 값이란 10, 10 / 14, 15 두 개의 숫자
    // Point는 좌표 객체만 알면 하나의 점이 될 수 있음
    private final int x;
    private final int y;
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 24;


    private Coordinate(int x, int y) {
        if (comparePosition(x) || comparePosition(y)) {
            throw new IllegalArgumentException("좌표는 0부터 24까지만 입력할 수 있습니다.");
        }

        this.x = x;
        this.y = y;
    }

    private boolean comparePosition(int number) {
        return number < LOWER_LIMIT || number > UPPER_LIMIT;
    }

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    public Point toPoint() {
        return Point.of(this);
    }

    public int getDeltaX(Coordinate other) {
        return this.x - other.x;
    }

    public int getDeltaY(Coordinate other) {
        return this.y - other.y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
