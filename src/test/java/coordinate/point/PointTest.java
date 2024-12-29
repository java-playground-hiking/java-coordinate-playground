package coordinate.point;

import static org.assertj.core.api.Assertions.*;

import coordinate.exception.CoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointTest {

    @ParameterizedTest
    @DisplayName("[정상] 좌표는 0 ~ 24까지의 값만 입력할 수 있다")
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
    @DisplayName("[예외] 좌표는 0 ~ 24까지의 값만 입력할 수 있다")
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
    @DisplayName("[정상] 좌표값이 같을 때 마크가 활성화 된다.")
    void testPointMarkIsTrue() {
        // Given
        Point point = Point.of(10, 10);

        // When
        boolean markIsEnabled = point.isMark(10, 10);

        // Then
        assertThat(markIsEnabled).isTrue();
    }

    @Test
    @DisplayName("[실패] 좌표값이 같을 때 마크가 활성화 된다.")
    void testPointMarkIsFalse() {
        // Given
        Point point = Point.of(10, 10);

        // When
        boolean markIsEnabled = point.isMark(10, 11);

        // Then
        assertThat(markIsEnabled).isFalse();
    }
}
