package entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    @DisplayName("올바른 좌표로 Rectangle 객체를 생성할 수 있는지 테스트")
    void shouldCreateRectangleFromValidPoints() {
        // Given
        Point topLeft = new Point(10, 10);
        Point bottomRight = new Point(20, 20);

        // When
        Rectangle rectangle = new Rectangle(topLeft, bottomRight);

        // Then
        assertNotNull(rectangle);
    }

    @Test
    @DisplayName("Rectangle의 넓이가 정확히 계산되는지 테스트")
    void shouldCalculateRectangleArea() {
        // Given
        Point topLeft = new Point(10, 10);
        Point bottomRight = new Point(20, 20);

        // When
        Rectangle rectangle = new Rectangle(topLeft, bottomRight);
        int area = rectangle.calculateArea();

        // Then
        assertEquals(100, area);
    }

    @Test
    @DisplayName("잘못된 좌표 배열로 Rectangle 생성 시 예외가 발생하는지 테스트")
    void shouldThrowExceptionForInvalidRectanglePoints() {
        // Given
        List<Point> invalidPoints = Arrays.asList(
                new Point(10, 10),
                new Point(15, 10),
                new Point(20, 15),
                new Point(10, 20)
        );

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> Rectangle.fromPoints(invalidPoints));
    }
}
