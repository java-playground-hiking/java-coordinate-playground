package model.coordinate;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.point.Point;
import model.point.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoordinatesTest {

    @Test
    @DisplayName("좌표들을 포인트들로 변환한다")
    void coordinatesToPoints() {
        Coordinates coordinates = Coordinates.from(
                List.of(Coordinate.of(10, 10), Coordinate.of(14, 15))
        );

        List<Point> points = List.of(Point.of(Coordinate.of(10, 10)), Point.of(Coordinate.of(14, 15)));

        assertThat(coordinates.toPoints()).isEqualTo(Points.from(points));
    }
    @Test
    @DisplayName("입력한 좌표의 갯수를 입력하면 일치하는지 결과를 반환한다")
    void coordinatesEqualSize() {
        Coordinates coordinates = Coordinates.from(
                List.of(Coordinate.of(10, 10), Coordinate.of(14, 15))
        );

        assertThat(coordinates.isEqualSize(2)).isTrue();


    }

}
