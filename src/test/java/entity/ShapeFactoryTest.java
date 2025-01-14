package entity;

import entity.ShapeFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeFactoryTest {

    @Test
    @DisplayName("올바른 문자열 입력으로 Rectangle 객체를 생성하는지 테스트")
    void shouldCreateRectangleFromValidInputString() {
        // Given
        String input = "(10,10)-(20,10)-(20,20)-(10,20)";

        // When
        Shape shape = ShapeFactory.createShape(input);

        // Then
        assertTrue(shape instanceof Rectangle);
    }

    @Test
    @DisplayName("잘못된 좌표 입력 시 예외를 발생시키는지 테스트")
    void shouldThrowExceptionForInvalidShapeInput() {
        // Given
        String input = "(10,10)-(15,10)-(20,15)";

        // When & Then
        assertThrows(UnsupportedOperationException.class, () -> ShapeFactory.createShape(input));
    }
}
