package coordinate.figure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FigureFactoryTest {

    @Test
    @DisplayName("2개의 좌표를 입력 하면 Line 객체를 반환한다")
    void testFigureFactoryCreateLine() {

        // Given
        FigureSize figureSize = FigureSize.from("(10,10)-(14,15)");

        // When
        Figure figure = FigureFactory.create(figureSize);

        // Then
        assertThat(figure).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("4개의 좌표를 입력 하면 Rectangle 객체를 반환한다")
    void testFigureFactoryCreateRectangle() {

        // Given
        FigureSize figureSize = FigureSize.from("(10,10)-(22,10)-(22,18)-(10,18)");

        // When
        Figure figure = FigureFactory.create(figureSize);

        // Then
        assertThat(figure).isInstanceOf(Rectangle.class);
    }
}
