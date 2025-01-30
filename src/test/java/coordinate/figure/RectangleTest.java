package coordinate.figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import coordinate.point.Point;
import coordinate.point.Points;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RectangleTest {

    private static Points points;

    @BeforeAll
    static void setUp() {
        points = Points.from(List.of(Point.of(10, 10), Point.of(22, 10), Point.of(22, 18), Point.of(10, 18)));
    }


    @ParameterizedTest
    @DisplayName("네 점의 위치와 좌표 위치가 같을 때 마크 표시 여부가 True 가 된다")
    @CsvSource(value = {"10,10", "22,10", "22,18", "10,18"})
    void testRectangleIsMark(int x, int y) {

        // Given
        Rectangle rectangle = Rectangle.from(points);

        // When
        boolean isMark = rectangle.isMark(x, y);

        // Then
        assertThat(isMark).isTrue();
    }

    @ParameterizedTest
    @DisplayName("네 점의 위치와 좌표 위치가 다른 경우 마크 표시 여부는 False 이다")
    @CsvSource(value = {"10,11", "2,10", "22,13", "5,18"})
    void testRectangleIsNotMark(int x, int y) {

        // Given
        Rectangle rectangle = Rectangle.from(points);

        // When
        boolean isMark = rectangle.isMark(x, y);

        // Then
        assertThat(isMark).isFalse();
    }

    @Test
    @DisplayName("사각형의 면접을 계산하는 반환 값을 검증한다")
    void testRectangleCalculate() {

        // Given
        Rectangle rectangle = Rectangle.from(points);

        // When
        double result = rectangle.calculate();

        // Then
        assertThat(result).isEqualTo(96.0, offset(0.00099));
    }

    @Test
    @DisplayName("Rectangle 객체를 문자열로 변환 할 시 사각형의 넓이를 반환한다")
    void testRectangleToString() {

        // Given
        Rectangle rectangle = Rectangle.from(points);

        // When
        String string = rectangle.toString();

        // Then
        assertThat(string).isEqualTo("사각형의 넓이는 " + 96);
    }
}
