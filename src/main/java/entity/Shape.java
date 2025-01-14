package entity;

/**
 * 모든 도형의 공통적인 기능을 정의하는 추상 클래스.
 * 모든 도형은 넓이를 계산하는 `calculateArea` 메서드를 구현해야 합니다.
 */
public abstract class Shape {
    public abstract int calculateArea(); // 넓이를 계산하는 메서드 (추상 메서드)
}
