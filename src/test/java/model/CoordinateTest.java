package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest {

    @Test
    @DisplayName("입력값 검증으로 true 반환")
    void isCorrectRangeTrue(){
        // given
        Coordinate coordinate = new Coordinate(24.0);

        // when
        boolean response = coordinate.isCorrectRange();

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("입력값 검증으로 false 반환")
    void isCorrectRangeFalse(){
        // given
        Coordinate coordinate = new Coordinate(24.1);

        // when
        boolean response = coordinate.isCorrectRange();

        // then
        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("좌표값 뺄셈")
    void minus(){
        // given
        Coordinate coordinate1 = new Coordinate(10);
        Coordinate coordinate2 = new Coordinate(5);

        // when
        double response = coordinate1.minus(coordinate2);

        // then
        assertThat(response).isEqualTo(5);

    }

    @Test
    @DisplayName("그래프 좌표 위치 반환")
    void getGraphPosition(){
        // given
        Coordinate coordinate1 = new Coordinate(10);

        // when
        int response = coordinate1.getGraphPosition();

        // then
        assertThat(response).isEqualTo(30);
    }

    @Test
    @DisplayName("다른 점과 y값이 같은 경우 그래프 좌표 위치 반환")
    void getGraphPositionDifference(){
        // given
        Coordinate coordinate1 = new Coordinate(10);
        Coordinate coordinate2 = new Coordinate(7);

        // when
        int response = coordinate1.getGraphPositionDifference(coordinate2);

        // then
        assertThat(response).isEqualTo(9);
    }
}
