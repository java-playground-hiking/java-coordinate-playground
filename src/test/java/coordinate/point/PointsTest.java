package coordinate.point;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointsTest {

    @ParameterizedTest
    @DisplayName("그래프의 좌표 값과 포인트의 좌표 값이 일치할 경우 마크 표시를 활성화한다")
    @CsvSource(value = {"10,10", "14,15"})
    void testPointsMark(int x, int y) {
        // Given
        Points points = Points.from(List.of(Point.of(10, 10), Point.of(14, 15)));

        // When
        boolean markedAt = points.isMarkedAt(x, y);

        // Then
        assertThat(markedAt).isTrue();
    }

    @ParameterizedTest
    @DisplayName("그래프의 좌표 값과 포인트의 좌표 값이 일치하지 않을 경우 마크 표시가 활성화 되지 않는다")
    @CsvSource(value = {"11,10", "14,16"})
    void testPointsIsNotMark(int x, int y) {
        // Given
        Points points = Points.from(List.of(Point.of(10, 10), Point.of(14, 15)));

        // When
        boolean markedAt = points.isMarkedAt(x, y);

        // Then
        assertThat(markedAt).isFalse();
    }

    @Test
    @DisplayName("입력한 좌표가 2개일 때 Points 객체의 사이즈는 2여야한다")
    void testPointsSizeTwo() {
        // Given
        Points points = Points.from(List.of(Point.of(10, 10), Point.of(14, 15)));

        // When
        int size = points.size();

        // Then
        assertThat(size).isEqualTo(2);
    }

    @Test
    @DisplayName("입력한 좌표가 4개일 때 Points 객체의 사이즈는 4여야한다")
    void testPointsSizeFour() {
        // Given
        Points points = Points.from(List.of(Point.of(10, 10), Point.of(20, 20), Point.of(22, 18), Point.of(10, 18)));

        // When
        int size = points.size();

        // Then
        assertThat(size).isEqualTo(4);
    }

    @Test
    @DisplayName("Points 객체가 가진 Point 배열을 반환한다")
    void testGetPoints() {
        // Given
        Points points = Points.from(List.of(Point.of(10, 10), Point.of(14, 15)));
        List<Point> pointList = List.of(Point.of(10, 10), Point.of(14, 15));

        // When
        List<Point> getPoints = points.getPoints();

        // Then
        assertThat(getPoints).isEqualTo(pointList);
    }
}
