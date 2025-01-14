package model;

public class DistanceCalculator {

    // 객체 생성을 방지하기 위해 private 생성자를 선언.
    private DistanceCalculator() {
    }

    // 두 점 사이의 거리를 계산 (단일 책임 원칙: 거리 계산만 수행).
    public static double calculate(Point p1, Point p2) {
        int dx = p1.getX() - p2.getX(); // X 좌표 차이 계산.
        int dy = p1.getY() - p2.getY(); // Y 좌표 차이 계산.
        return Math.sqrt(dx * dx + dy * dy); // 유클리드 거리 반환.
    }
}