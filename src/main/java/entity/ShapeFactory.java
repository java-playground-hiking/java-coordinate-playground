package entity;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactory {
    public static Shape createShape(String input) {
        String[] pointStrings = input.split("-");
        List<Point> points = new ArrayList<>();

        for (String pointString : pointStrings) {
            points.add(Point.fromString(pointString));
        }

        if (points.size() == 2) {
            return new Line(points.get(0), points.get(1));
        }

        if (points.size() == 3) {
            return Triangle.fromPoints(points);
        }

        throw new IllegalArgumentException("지원하지 않는 점 개수입니다. 직선(2점) 또는 삼각형(3점)을 입력하세요.");
    }
}
