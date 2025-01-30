package coordinate.figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import coordinate.exception.CoordinateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FigureTypeTest {

    @Test
    @DisplayName("2개의 좌표를 입력하면 Line 객체를 반환한다")
    void testLineFigureType() {
        // Given
        FigureSize figureSize = FigureSize.from("(10,10)-(14,15)");

        // When
        Figure line = FigureType.create(figureSize);

        // Then
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("4개의 좌표를 입력하면 Rectangle 객체를 반환한다")
    void testRectangleFigureType() {
        // Given
        FigureSize figureSize = FigureSize.from("(10,10)-(22,10)-(22,18)-(10,18)");

        // When
        Figure rectangle = FigureType.create(figureSize);

        // Then
        assertThat(rectangle).isInstanceOf(Rectangle.class);
    }

    @ParameterizedTest
    @DisplayName("정의 되지 않은 좌표 개 수를 입력하면 예외를 반환한다")
    @CsvSource(value = {"(10,10)-(1,1)-(1,2)-(1,3)-(1,4):", "(1,1)-"}, delimiter = ':')
    void testInvalidCoordinateSizes(String testFigureSize) {
        // Given
        FigureSize figureSize = FigureSize.from(testFigureSize);

        assertThatThrownBy(() -> {
            // When
            FigureType.create(figureSize);
        })
                // Then
                .hasMessage("해당 좌표로 도형을 생성 할 수 없습니다.")
                .isInstanceOf(CoordinateException.class);
    }

}
