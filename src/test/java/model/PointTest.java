package model;

import messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    @DisplayName("객체 생성")
    void of(){
        // given, when, then
        assertDoesNotThrow(() -> Point.of(24, 0));

    }

    @Test
    @DisplayName("객체 생성 시  x 좌표 범위 예외 발생")
    void of_invalidateXRange(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> Point.of(25, 0));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE);
    }

    @Test
    @DisplayName("객체 생성 시 y 좌표 범위 예외 발생")
    void of_invalidateYRange(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> Point.of(24, -1));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE);
    }

    @Test
    @DisplayName("x 좌표 뺄셈")
    void minusX(){
        // given
        Point point1 = Point.of(24, 0);
        Point point2 = Point.of(0, 24);

        // when
        double response = point1.minusX(point2);

        // then
        assertThat(response).isEqualTo(24);
    }

    @Test
    @DisplayName("y 좌표 뺄셈")
    void minusY(){
        // given
        Point point1 = Point.of(24, 0);
        Point point2 = Point.of(0, 24);

        // when
        double response = point1.minusY(point2);

        // then
        assertThat(response).isEqualTo(-24);
    }

    @Test
    @DisplayName("좌표 그리기")
    void drawPoint(){
        // given
        StringBuilder[] graph = new StringBuilder[1];
        graph[0] = new StringBuilder().append(" ");

        Point point = Point.of(0, 24);

        // when
        point.drawPoint(graph);

        // then
        assertThat(graph[0]).contains("●");


    }

}