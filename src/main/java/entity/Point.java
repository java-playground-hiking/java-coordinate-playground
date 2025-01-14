package entity;

/**
 * 좌표를 나타내는 클래스.
 * x와 y 좌표를 저장하며, 문자열 입력에서 Point 객체로 변환하는 기능을 포함합니다.
 */
public class Point {
    private final int x; // x 좌표
    private final int y; // y 좌표

    // 생성자: x와 y 좌표를 초기화합니다.
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x; // x 좌표 반환
    }

    public int getY() {
        return y; // y 좌표 반환
    }

    /**
     * "(x,y)" 형식의 문자열을 받아 Point 객체로 변환합니다.
     * 예: "(10,10)" -> Point(10, 10)
     */
    public static Point fromString(String input) {
        String[] coordinates = input.replaceAll("[()]", "").split(",");
        return new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }
}
