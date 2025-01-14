package validation;

import entity.Point;

import java.util.List;

public class RectangleValidator {
    /**
     * 주어진 점들이 직사각형을 형성하는지 검증합니다.
     * 조건:
     * 1. 점의 개수는 4개여야 한다.
     * 2. 평행한 두 세로선과 두 가로선이 있어야 한다.
     */
    public static void validate(List<Point> points) {
        if (points.size() != 4) {
            throw new IllegalArgumentException("A rectangle must have exactly 4 points.");
        }

        // 직사각형 조건 확인
        boolean areLinesParallel =
                points.get(0).getY() == points.get(1).getY() &&  // 위쪽 선 평행
                        points.get(2).getY() == points.get(3).getY() &&  // 아래쪽 선 평행
                        points.get(0).getX() == points.get(3).getX() &&  // 왼쪽 선 평행
                        points.get(1).getX() == points.get(2).getX();    // 오른쪽 선 평행

        if (!areLinesParallel) {
            throw new IllegalArgumentException("The given points do not form a valid rectangle.");
        }
    }
}
