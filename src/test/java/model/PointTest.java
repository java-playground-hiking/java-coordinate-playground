package model;

import messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("x, y 좌표 범위 유효성 체크")
    void validateRange(){
        // given
        Point point = new Point(24, 0);

        // when, then
        assertDoesNotThrow(point::validateRange);

    }

    @Test
    @DisplayName("x, y 좌표 범위 유효성 체크 시 x 좌표 예외 발생")
    void InvalidateXRange(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> new Point(25, 0));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE);
    }

    @Test
    @DisplayName("x, y 좌표 범위 유효성 체크 시 Y 좌표 예외 발생")
    void InvalidateYRange(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> new Point(24, -1));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE);
    }

    @Test
    @DisplayName("범위 체크 시 true 반환")
    void isCorrectRange_true(){
        // given
        Point point = new Point();

        // when
        boolean response = point.isCorrectRange(24);

        // then
        assertThat(response).isTrue();

    }

    @Test
    @DisplayName("범위 체크 시 false 반환")
    void isCorrectRange_false(){
        // given
        Point point = new Point();

        // when
        boolean response = point.isCorrectRange(25);

        // then
        assertThat(response).isFalse();
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