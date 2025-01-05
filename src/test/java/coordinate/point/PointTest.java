package coordinate.point;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import coordinate.exception.CoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointTest {

    @ParameterizedTest
    @DisplayName("좌표는 0 ~ 24까지의 값만 입력할 수 있다")
    @CsvSource({"0,24"})
    void testPointValidateByMinMaxValues(int x, int y) {
        // Given
        Point given = Point.of(0, 24);

        // When
        Point point = Point.of(x, y);

        // Then
        assertThat(point).isEqualTo(given);
    }

    @ParameterizedTest
    @DisplayName("입력한 좌표가 0 ~ 24 범위를 벗어나면 예외를 반환한다")
    @CsvSource({"-1,24", "0,25"})
    void testPointValidateByMinMaxValuesException(int x, int y) {
        assertThatThrownBy(() -> {
            // Given & When
            Point.of(x, y);
        })
                // Then
                .hasMessage("좌표는 최소 0부터 최대 24까지 입력 할 수 있습니다.")
                .isInstanceOf(CoordinateException.class);
    }

    @Test
    @DisplayName("좌표값이 같을 때 마크 표시 상태값이 활성화된다.")
    void testPointMarkIsTrue() {
        // Given
        Point point = Point.of(10, 10);

        // When
        boolean markIsEnabled = point.isSamePosition(10, 10);

        // Then
        assertThat(markIsEnabled).isTrue();
    }

    @Test
    @DisplayName("좌표값이 같지 않으면 마크 표시 상태값이 활성화 되지 않는다.")
    void testPointMarkIsFalse() {
        // Given
        Point point = Point.of(10, 10);

        // When
        boolean markIsEnabled = point.isSamePosition(10, 11);

        // Then
        assertThat(markIsEnabled).isFalse();
    }

    @Test
    @DisplayName("두 점에서 X좌표 끼리 뺄셈 연산을 한다.")
    void testSubtractByX() {
        // Given
        Point firstPoint = Point.of(10, 10);
        Point secondPoint = Point.of(20, 20);

        // When
        int result = firstPoint.subtractionByX(secondPoint);

        // Then
        assertThat(result).isEqualTo(-10);
    }

    @Test
    @DisplayName("두 점에서 Y좌표 끼리 뺄셈 연산을 한다.")
    void testSubtractByY() {
        // Given
        Point firstPoint = Point.of(10, 14);
        Point secondPoint = Point.of(20, 20);

        // When
        int result = firstPoint.subtractionByY(secondPoint);

        // Then
        assertThat(result).isEqualTo(-6);
    }
}
