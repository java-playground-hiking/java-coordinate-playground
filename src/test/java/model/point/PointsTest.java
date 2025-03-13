package model.point;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.coordinate.Coordinate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointsTest {

    @Test
    @DisplayName("2개의 포인트를 생성하면 포인트 배열의 사이즈는 2이다")
    void createPoints() {
        Point point1 = Point.of(Coordinate.of(10, 10));
        Point point2 = Point.of(Coordinate.of(14, 15));

        List<Point> twoPoint = List.of(point1, point2);

        Points points = Points.from(twoPoint);
        assertThat(points.isEqualSize(2)).isTrue();
    }

    @Test
    @DisplayName("포인트의 인덱스 번호를 입력하면 해당 포인트를 반환한다")
    void getPoint() {
        Point point1 = Point.of(Coordinate.of(10, 10));
        Point point2 = Point.of(Coordinate.of(14, 15));

        assertThat(Points.from(List.of(point1, point2)).at(0)).isEqualTo(point1);
    }

    @Test
    @DisplayName("3개 이상의 점이 존재하는 배열에서 각 점 사이의 거리를 계산한다")
    void pointsDistanceToFourPoints() {
        Point point1 = Point.of(Coordinate.of(10, 10));
        Point point2 = Point.of(Coordinate.of(14, 15));
        Point point3 = Point.of(Coordinate.of(22, 18));
        Point point4 = Point.of(Coordinate.of(10, 18));
        Points points = Points.from(List.of(point1, point2, point3, point4));

        assertThat(points.calculateDistance()).hasSize(4).contains(6.4031242374328485);
    }

    @Test
    @DisplayName("2개만 존재하는 배열에서 점과 점 사이의 거리를 계산한다")
    void pointsDistanceToTwoPoints() {
        Point point1 = Point.of(Coordinate.of(10, 10));
        Point point2 = Point.of(Coordinate.of(14, 15));
        Points points = Points.from(List.of(point1, point2));

        assertThat(points.calculateDistance()).hasSize(1).containsExactly(6.4031242374328485);
    }

}
