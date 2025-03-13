package model.figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.List;
import model.coordinate.Coordinate;
import model.point.Point;
import model.point.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("좌표 갯수가 2개가 아니면 도형을 생성할 수 없다")
    void lineCreate() {
        Point coordinate1 = Coordinate.of(10, 10).toPoint();
        Point coordinate2 = Coordinate.of(14, 15).toPoint();
        Point coordinate3 = Coordinate.of(21, 22).toPoint();

        assertThatThrownBy(() -> {
            Line.from(Points.from(List.of(coordinate1, coordinate2, coordinate3)));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2개의 좌표만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("두개의 좌표를 입력 하면 두 점 사이의 길이를 반환한다")
    void lineLength() {
        Coordinate coordinate1 = Coordinate.of(10, 10);
        Coordinate coordinate2 = Coordinate.of(14, 15);
        Points points = Points.from(List.of(Point.of(coordinate1), Point.of(coordinate2)));

        assertThat(Line.from(points).calculate()).isEqualTo(6.403124, offset(0.00099));
    }

    @Test
    @DisplayName("도형을 출력하면 해당 도형의 길이와 안내 문구를 같이 반환한다")
    void lineToString() {
        Coordinate coordinate1 = Coordinate.of(10, 10);
        Coordinate coordinate2 = Coordinate.of(14, 15);
        Points points = Points.from(List.of(Point.of(coordinate1), Point.of(coordinate2)));

        assertThat(Line.from(points).toString()).isEqualTo("두 점 사이의 거리는 6.403124");
    }
}
