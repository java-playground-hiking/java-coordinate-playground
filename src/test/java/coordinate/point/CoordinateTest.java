package coordinate.point;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import coordinate.exception.CoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoordinateTest {


    @Test
    @DisplayName("좌표는 '(x,y)' 형태로 입력해야 한다.")
    void testCoordinateValidation() {
        // Given
        String coordinateInput = "(10,10)";

        // When
        Coordinate coordinate = Coordinate.from(coordinateInput);

        // Then
        assertThat(coordinate.toPoint()).isEqualTo(Point.of(10, 10));
    }

    @Test
    @DisplayName("좌표를 입력할 때 괄호 형식을 지키지 않으면 예외를 반환한다")
    void testCoordinateBracketValidation() {
        // Given
        String coordinateInput = "10,10";

        assertThatThrownBy(() -> {
            // When
            Coordinate.from(coordinateInput);
        })
                // Then
                .hasMessage("좌표는 '(x, y) 형식으로 입력하며 숫자만 입력 해야 합니다.")
                .isInstanceOf(CoordinateException.class);
    }

    @Test
    @DisplayName("좌표에 입력한 값이 숫자가 아닌 경우 예외를 반환한다")
    void testCoordinateValueValidation() {
        // Given
        String coordinateInput = "(10,a)";

        assertThatThrownBy(() -> {
            // When
            Coordinate.from(coordinateInput);
        })
            // Then
                .hasMessage("좌표는 '(x, y) 형식으로 입력하며 숫자만 입력 해야 합니다.")
                .isInstanceOf(CoordinateException.class);
    }
}
