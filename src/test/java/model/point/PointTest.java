package model.point;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import model.coordinate.Coordinate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    @DisplayName("좌표 값을 입력하여 포인트로 변환 하면 좌표 값이 같은 포인트가 생성 되어야한다")
    void createPoint() {
        Coordinate coordinate = Coordinate.of(0, 24);

        Point point = coordinate.toPoint();

        assertThat(point).isEqualTo(Point.of(Coordinate.of(0, 24)));
    }

    @Test
    @DisplayName("두 점 사이의 거리를 구한다")
    void distance() {
        Point point = Point.of(Coordinate.of(10, 10));
        Point point2 = Point.of(Coordinate.of(14, 15));

        assertThat(point.distanceTo(point2)).isEqualTo(6.403124, offset(0.00099));
    }
}
