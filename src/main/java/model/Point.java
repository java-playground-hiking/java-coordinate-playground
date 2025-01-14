package model;

public class Point {
    private final int x; // 점의 X 좌표.
    private final int y; // 점의 Y 좌표.

    // 생성자에서 좌표를 초기화하며 유효성 검사.
    public Point(int x, int y) {
        if (x > 24 || y > 24) {
            throw new IllegalArgumentException("좌표 값은 0에서 24 사이여야 합니다.");
        }
        this.x = x;
        this.y = y;
    }

    // X 좌표 반환.
    public int getX() {
        return x;
    }

    // Y 좌표 반환.
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")"; // (x, y) 형식으로 좌표 반환.
    }
}