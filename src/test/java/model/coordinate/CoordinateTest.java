package model.coordinate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import model.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CoordinateTest {

    @Test
    @DisplayName("숫자 좌표를 포인트로 변환 하면 x, y 값이 같은 포인트 도형이 반환된다")
    void coordinateToPoint() {
        Coordinate coordinate = Coordinate.of(10, 10);

        assertThat(coordinate.toPoint()).isEqualTo(Point.of(Coordinate.of(10, 10)));
    }

    @Test
    @DisplayName("좌표 크기의 제한 숫자를 초과 하거나 미만인 값을 입력하면 좌표 생성 오류가 발생한다")
    void invalidInputCoordinate() {
        int x = -1;
        int y = 25;

        assertThatThrownBy(() -> Coordinate.of(x, y))
                .hasMessage("좌표는 0부터 24까지만 입력할 수 있습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("해당 좌표의 X 값과 다른 좌표의 X 값을 뺄셈한다")
    void coordinateDeltaX() {
        Coordinate thisCoordinate = Coordinate.of(10, 10);
        Coordinate otherCoordinate = Coordinate.of(14, 15);

        assertThat(thisCoordinate.getDeltaX(otherCoordinate)).isEqualTo(-4);
    }

    @Test
    @DisplayName("해당 좌표의 Y 값과 다른 좌표의 X 값을 뺄셈한다")
    void coordinateDeltaY() {
        Coordinate thisCoordinate = Coordinate.of(10, 10);
        Coordinate otherCoordinate = Coordinate.of(14, 15);

        assertThat(thisCoordinate.getDeltaY(otherCoordinate)).isEqualTo(-5);
    }

}
