package validation;

import entity.Point;

import java.util.List;

public class TriangleValidator {
    public static void validate(List<Point> points) {
        if (points.size() != 3) {
            throw new IllegalArgumentException("삼각형은 반드시 3개의 점이 필요합니다.");
        }

        double sideA = points.get(0).distanceTo(points.get(1));
        double sideB = points.get(1).distanceTo(points.get(2));
        double sideC = points.get(2).distanceTo(points.get(0));

        if (sideA + sideB <= sideC || sideB + sideC <= sideA || sideC + sideA <= sideB) {
            throw new IllegalArgumentException("주어진 점들로는 삼각형을 만들 수 없습니다.");
        }
    }
}
