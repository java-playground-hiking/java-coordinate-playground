package entity;

import validation.RectangleValidator;

import java.util.List;

/**
 * 직사각형을 나타내는 클래스.
 * 꼭짓점 두 개(topLeft, bottomRight)로 정의되며, 넓이를 계산하는 기능을 제공합니다.
 */
public class Rectangle extends Shape {
    private final Point topLeft;       // 직사각형의 왼쪽 위 점
    private final Point bottomRight;  // 직사각형의 오른쪽 아래 점

    // 생성자: 직사각형의 꼭짓점 두 개를 초기화합니다.
    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    /**
     * 4개의 좌표로부터 직사각형 객체를 생성합니다.
     * 사각형 검증은 RectangleValidator 클래스를 사용합니다.
     */
    public static Rectangle fromPoints(List<Point> points) {
        RectangleValidator.validate(points); // 유효성 검사
        Point topLeft = points.get(0);       // 왼쪽 위 점
        Point bottomRight = points.get(2);   // 오른쪽 아래 점
        return new Rectangle(topLeft, bottomRight);
    }

    /**
     * 직사각형의 넓이를 계산합니다.
     * 넓이는 |가로| * |세로|로 계산됩니다.
     */
    @Override
    public int calculateArea() {
        int width = Math.abs(topLeft.getX() - bottomRight.getX());  // 가로 길이
        int height = Math.abs(topLeft.getY() - bottomRight.getY()); // 세로 길이
        return width * height; // 넓이 계산
    }
}
