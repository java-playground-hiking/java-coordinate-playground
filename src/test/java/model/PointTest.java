package model;

import messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {

    @Test
    @DisplayName("x, y 좌표값 범위 유효성 검사")
    void validateRange(){
        // given
        Point point = Point.from(24.0, 0.0);

        // when, then
        assertDoesNotThrow(point::validateRange);
    }

    @Test
    @DisplayName("x 좌표값 범위 초과로 예외 발생")
    void validateRange_overRangeX(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> Point.from(24.1, 0.0));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE_INPUT);

    }

    @Test
    @DisplayName("y 좌표값 범위 초과로 예외 발생")
    void validateRange_overRangeY(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> Point.from(24.0, -0.9));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE_INPUT);

    }

    @Test
    @DisplayName("x, y 좌표값 범위 초과로 예외 발생")
    void validateRange_overRangeXY(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> Point.from(24.1, -0.9));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE_INPUT);

    }

    @Test
    @DisplayName("x 값 뺄셈")
    void minusX(){
        // given
        Point point1 = Point.from(10, 10);
        Point point2 = Point.from(5, 5);

        // when
        double response = point1.minusX(point2);

        // then
        assertThat(response).isEqualTo(5);
    }

    @Test
    @DisplayName("y 값 뺄셈")
    void minusY(){
        // given
        Point point1 = Point.from(10, 10);
        Point point2 = Point.from(5, 5);

        // when
        double response = point1.minusY(point2);

        // then
        assertThat(response).isEqualTo(5);
    }

    @Test
    @DisplayName("y 좌표 같아 좌표 그림 추가")
    void drawPointIfMatchY(){
        // given
        Point point1 = Point.from(2, 1);
        StringBuilder sb = new StringBuilder();

        // when
        point1.drawPointIfMatchY(1, sb);

        // then
        assertThat(sb.toString()).isEqualTo("      ㆍ");
    }

    @Test
    @DisplayName("y 좌표 같지 않아서 좌표 그림 추가 안됨")
    void drawPointIfNotMatchY(){
        // given
        Point point1 = Point.from(2, 1);
        StringBuilder sb = new StringBuilder();

        // when
        point1.drawPointIfMatchY(5, sb);

        // then
        assertThat(sb.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("다른 점과 y 좌표 같은 같으면서 인자로 넘어온 y 값과 같아 좌표 그림 추가")
    void drawPointIfMatchY_matchOtherPoint(){
        // given
        Point point1 = Point.from(2, 1);
        Point point2 = Point.from(3, 1);
        StringBuilder sb = new StringBuilder();

        // when
        point1.drawPointIfMatchY(1, sb, point2);

        // then
        assertThat(sb.toString()).isEqualTo("   ㆍ");
    }

    @Test
    @DisplayName("다른 점과 y 좌표 같은 같으면서 인자로 넘어온 y 값과 같지 않아 좌표 그림 추가 안됨")
    void drawPointIfNotMatchY_matchOtherPoint(){
        // given
        Point point1 = Point.from(2, 1);
        Point point2 = Point.from(3, 1);
        StringBuilder sb = new StringBuilder();

        // when
        point1.drawPointIfMatchY(5, sb, point2);

        // then
        assertThat(sb.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("y 좌표 같아 true 반환")
    void isEqualY_true(){
        // given
        Point point1 = Point.from(2, 10);

        // when
        boolean response = point1.isEqualY(10);

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("y 좌표 같아 false 반환")
    void isEqualY_false(){
        // given
        Point point1 = Point.from(2, 10);

        // when
        boolean response = point1.isEqualY(5);

        // then
        assertThat(response).isFalse();
    }


}
