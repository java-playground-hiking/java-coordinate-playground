package coordinate.figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import coordinate.point.Point;
import coordinate.point.Points;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    private static Points points;

    @BeforeAll
    static void setUp() {
        points = Points.from(List.of(Point.of(10, 10), Point.of(14, 15), Point.of(20, 8)));
    }

    @Test
    @DisplayName("삼각형의 면적을 계산하는 반환 값을 검증한다")
    void testTriangleCalculate() {
        // Given
        Triangle rectangle = Triangle.from(points);

        // When
        double result = rectangle.calculate();

        // Then
        assertThat(result).isEqualTo(29.0, offset(0.00099));
    }

    @Test
    @DisplayName("Rectangle 객체를 문자열로 변환 할 시 사각형의 넓이를 반환한다")
    void testTriangleToString() {

        // Given
        Triangle rectangle = Triangle.from(points);

        // When
        String string = rectangle.toString();

        // Then
        assertThat(string).isEqualTo("삼각형의 넓이는 " + 29.0);
    }

}
