package model;

import exception.CoordinateException;
import exception.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {

    @Test
    @DisplayName("points 객체 생성1")
    void fromTwo(){
        // given
        List<Integer> numbers = List.of(10, 0, 24, 15);

        // when
        Points points = Points.from(numbers);

        // then
        assertThat(points.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("points 객체 생성2")
    void fromThree(){
        // given
        List<Integer> numbers = List.of(10, 10, 14, 0, 24, 15);

        // when
        Points points = Points.from(numbers);

        // then
        assertThat(points.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("points 객체 생성3")
    void fromFour(){
        // given
        List<Integer> numbers = List.of(10, 10, 14, 0, 24, 15, 22, 18);

        // when
        Points points = Points.from(numbers);

        // then
        assertThat(points.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("points 객체 생성 시 제한 범위를 초과해 예외 발생")
    void fromException(){
        // given
        List<Integer> numbers = List.of(10, 10, 14, 0, 25, 15, 22, 18);

        // when
        CoordinateException fail = assertThrows(CoordinateException.class, () -> Points.from(numbers));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.OVER_NUMBER);
    }
}
