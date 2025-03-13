package model.figure;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import model.coordinate.Coordinate;
import model.point.Point;
import model.point.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    @DisplayName("사각형은 4개의 좌표로만 생성할 수 있다")
    void create() {
        Point coordinate1 = Coordinate.of(10, 10).toPoint();
        Point coordinate2 = Coordinate.of(22, 10).toPoint();
        Point coordinate3 = Coordinate.of(22, 18).toPoint();

        assertThatThrownBy(() -> {
            Rectangle.from(Points.from(List.of(coordinate1, coordinate2, coordinate3)));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 4개의 좌표로 생성할 수 있습니다.");

    }

    @Test
    @DisplayName("사각형의 넓이를 계산한다")
    void calculate() {
        Point coordinate1 = Coordinate.of(10, 10).toPoint();
        Point coordinate2 = Coordinate.of(22, 10).toPoint();
        Point coordinate3 = Coordinate.of(22, 18).toPoint();
        Point coordinate4 = Coordinate.of(10, 18).toPoint();

        assertThat(Rectangle.from(Points.from(List.of(coordinate1, coordinate2, coordinate3, coordinate4)))
                .calculate()).isEqualTo(96.0);
    }

    @Test
    @DisplayName("사각형을 출력하면 안내 문구와 넓이 값을 반환한다")
    void rectangleToString() {
        Point coordinate1 = Coordinate.of(10, 10).toPoint();
        Point coordinate2 = Coordinate.of(22, 10).toPoint();
        Point coordinate3 = Coordinate.of(22, 18).toPoint();
        Point coordinate4 = Coordinate.of(10, 18).toPoint();

        assertThat(Rectangle.from(Points.from(List.of(coordinate1, coordinate2, coordinate3, coordinate4)))
                .toString()).isEqualTo("사각형 넓이는 96");


    }

}
