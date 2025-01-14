package entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("Point 객체가 주어진 x, y 좌표로 생성되는지 테스트")
    void shouldCreatePointWithGivenCoordinates() {
        // Given
        int x = 10;
        int y = 20;

        // When
        Point point = new Point(x, y);

        // Then
        assertEquals(10, point.getX());
        assertEquals(20, point.getY());
    }

    @Test
    @DisplayName("문자열 입력을 통해 Point 객체를 생성할 수 있는지 테스트")
    void shouldConvertStringToPoint() {
        // Given
        String input = "(10,20)";

        // When
        Point point = Point.fromString(input);

        // Then
        assertEquals(10, point.getX());
        assertEquals(20, point.getY());
    }

    @Test
    @DisplayName("잘못된 문자열 형식이 주어졌을 때 예외를 발생시키는지 테스트")
    void shouldThrowExceptionForInvalidStringFormat() {
        // Given
        String input = "10,20";

        // When & Then
        assertThrows(NumberFormatException.class, () -> Point.fromString(input));
    }
}
