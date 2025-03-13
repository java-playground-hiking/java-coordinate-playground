package model.figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.coordinate.Coordinate;
import model.point.Point;
import model.point.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    @DisplayName("삼각형은 3개의 좌표로만 생성할 수 있다")
    void create() {
        Point coordinate1 = Coordinate.of(10, 10).toPoint();
        Point coordinate2 = Coordinate.of(14, 15).toPoint();

        assertThatThrownBy(() -> {
            Triangle.from(Points.from(List.of(coordinate1, coordinate2)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형은 3개의 좌표로 생성할 수 있습니다.");

    }

    @Test
    @DisplayName("삼각형의 넓이를 계산한다")
    void calcualte() {
        Point coordinate1 = Coordinate.of(10, 10).toPoint();
        Point coordinate2 = Coordinate.of(14, 15).toPoint();
        Point coordinate3 = Coordinate.of(20, 8).toPoint();

        assertThat(Triangle.from(Points.from(List.of(coordinate1, coordinate2, coordinate3))).calculate()).isEqualTo(
                29.0);

    }

}
