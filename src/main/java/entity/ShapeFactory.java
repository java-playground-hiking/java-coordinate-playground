package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 입력을 기반으로 적절한 도형 객체를 생성하는 클래스.
 * 직사각형(Rectangle)만
 */
public class ShapeFactory {
    /**
     * 문자열 입력을 받아 도형 객체를 생성합니다.
     * 예: "(10,10)-(22,10)-(22,18)-(10,18)" -> Rectangle 객체
     */
    public static Shape createShape(String input) {
        String[] pointStrings = input.split("-"); // "-"로 좌표 문자열 구분
        List<Point> points = new ArrayList<>();

        for (String pointString : pointStrings) {
            points.add(Point.fromString(pointString)); // 문자열 -> Point 변환
        }

        if (points.size() == 4) { // 4개의 점이면 직사각형 생성
            return Rectangle.fromPoints(points);
        }

        throw new UnsupportedOperationException("Unsupported shape with the given points."); // 예외 처리
    }
}
