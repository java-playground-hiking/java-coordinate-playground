package validation;

import entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangleValidatorTest {

    @Test
    @DisplayName("유효한 사각형 좌표 배열이 검증을 통과하는지 테스트")
    void shouldValidateRectanglePoints() {
        // Given
        List<Point> validPoints = Arrays.asList(
                new Point(10, 10),
                new Point(20, 10),
                new Point(20, 20),
                new Point(10, 20)
        );

        // When & Then
        assertDoesNotThrow(() -> RectangleValidator.validate(validPoints));
    }

    @Test
    @DisplayName("비정상적인 사각형 좌표 배열로 예외를 발생시키는지 테스트")
    void shouldThrowExceptionForInvalidRectanglePoints() {
        // Given
        List<Point> invalidPoints = Arrays.asList(
                new Point(10, 10),
                new Point(15, 10),
                new Point(20, 15),
                new Point(10, 25)
        );

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> RectangleValidator.validate(invalidPoints));
    }

    @Test
    @DisplayName("좌표 배열이 4개 미만일 때 예외를 발생시키는지 테스트")
    void shouldThrowExceptionForLessThanFourPoints() {
        // Given
        List<Point> insufficientPoints = Arrays.asList(
                new Point(10, 10),
                new Point(20, 10),
                new Point(20, 20)
        );

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> RectangleValidator.validate(insufficientPoints));
    }
}
