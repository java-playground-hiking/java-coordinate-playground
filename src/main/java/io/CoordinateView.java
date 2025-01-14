package io;

public class CoordinateView {

    // 계산된 거리를 출력 (단일 책임 원칙: 출력만 처리).
    public void printDistance(double distance) {
        System.out.printf("두 점 사이의 거리는 %.6f입니다.\n", distance);
    }
}