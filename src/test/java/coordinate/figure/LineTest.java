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

public class LineTest {

    private static Points points;

    @BeforeAll
    static void setUp() {
        points = Points.from(List.of(Point.of(10, 10), Point.of(14, 15)));
    }

    @ParameterizedTest
    @DisplayName("두 점의 위치와 좌표 위치가 같을 때 마크 표시 여부가 True 가 된다")
    @CsvSource(value = {"10,10", "14,15"})
    void testLineIsMark(int x, int y) {

        // Given
        Line line = Line.from(points);

        // When
        boolean isMark = line.isMark(x, y);

        // Then
        assertThat(isMark).isTrue();
    }

    @ParameterizedTest
    @DisplayName("두 점의 위치와 좌표 위치가 다르면 마크 표시 여부가 False 이다")
    @CsvSource(value = {"10,11", "14,16"})
    void testLineIsNotMark(int x, int y) {

        // Given
        Line line = Line.from(points);

        // When
        boolean isMark = line.isMark(x, y);

        // Then
        assertThat(isMark).isFalse();
    }

    @Test
    @DisplayName("두 점사이의 거리를 계산한 값을 검증한다")
    void testLineDistanceBetweenPoints() {

        // Given
        Line line = Line.from(points);

        // When
        double distance = line.calculate();

        // Then
        assertThat(distance).isEqualTo(6.40312, offset(0.00099));
    }

    @Test
    @DisplayName("Line 객체를 문자열로 반환할 시 두 점 사이의 거리를 출력 해야한다")
    void testLineToString() {

        // Given
        Line line = Line.from(points);

        // When
        String string = line.toString();

        // Then
        assertThat(string).isEqualTo("두 점 사이의 거리는: " + 6.4031242374328485);
    }
}
