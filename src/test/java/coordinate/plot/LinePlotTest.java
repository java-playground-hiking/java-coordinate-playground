package coordinate.plot;

import static org.assertj.core.api.Assertions.*;

import coordinate.exception.CoordinateException;
import coordinate.point.Point;
import coordinate.point.PointList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinePlotTest {

    @Test
    @DisplayName("[정상] 문자열을 입력 하면 두 점의 좌표를 반환한다")
    void testLinePlotToPoints() {
        // Given
        String input = "(10,10)-(14,15)";
        PointList points = PointList.from(List.of(Point.of(10, 10), Point.of(14, 15)));

        // When
        LinePlot linePlot = LinePlot.from(input);

        // Then
        assertThat(linePlot.getFigureSize()).isEqualTo(points);
    }

    @Test
    @DisplayName("[실패] 좌표에 숫자가 아닌 문자를 입력할 시 예외를 반환한다")
    void TestLinePlotToPointsExceptionByString() {
        // Given
        String input = "(10,asd)-(14,15)";

        // When
        assertThatThrownBy(() -> {
            LinePlot.from(input);
        }).hasMessage("좌표는 '(x, y) 형식으로 입력하며 숫자만 입력 해야 합니다.")
                .isInstanceOf(CoordinateException.class);
    }

    @Test
    @DisplayName("[실패] 두 점의 좌표를 '-'으로 구분하지 않는 경우 예외를 반환한다")
    void testLinePlotToPointExceptionByHyphenSeperate() {
        // Given
        String input = "(10,10),(14,15)";

        // When
        assertThatThrownBy(() -> {
            LinePlot.from(input);
        }).hasMessage("두 점의 좌표를 구분을 위해 '-' 필수로 입력 해야 합니다.")
                .isInstanceOf(CoordinateException.class);
    }

    @Test
    @DisplayName("두 점의 사이 값을 검증한다")
    void testLinePlotCalculateDistance() {
        // Given
        String input = "(10,10)-(14,15)";

        // When
        double distance = LinePlot.from(input).distanceBetweenPoints();

        // Then
        assertThat(distance).isEqualTo(6.403124, offset(0.00099));
    }
}
