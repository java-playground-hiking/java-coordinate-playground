package model;

import exception.CoordinateException;
import exception.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    @DisplayName("point 객체 생성")
    void of(){
        // given
        // when
        Point response = Point.of(3, 5);

        // then
        assertThat(response).isEqualTo(new Point(3, 5));
    }

    @ParameterizedTest
    @CsvSource({"0, 14", "24, 3"})
    @DisplayName("x, y 범위 검증 통과")
    void validateRangeNumber(int x, int y){
        // given
        Point point = new Point();

        // when
        // then
        assertThatCode(() -> point.validateRange(x, y))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"-1, 14", "25, 3"})
    @DisplayName("x, y 범위 검증 통과 실패")
    void validateRangeNumber_exception(int x, int y){
        // given
        Point point = new Point();

        // when
        // then
        assertThatThrownBy(() -> point.validateRange(x, y))
                .isInstanceOf(CoordinateException.class)
                .hasMessage(ErrorMessages.OVER_NUMBER);
    }

    @ParameterizedTest
    @CsvSource(value = {"10", "14", "24", "0"})
    @DisplayName("숫자 범위 검증 true 반환")
    void isCorrectRange_true(int request){
        // given
        Point point = new Point();

        // when
        boolean response = point.isCorrectRange(request);

        // then
        assertThat(response).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "25", "300", "-1000"})
    @DisplayName("숫자 범위 검증 false 반환")
    void isCorrectRange_false(int request){
        // given
        Point point = new Point();

        // when
        boolean response = point.isCorrectRange(request);

        // then
        assertThat(response).isFalse();
    }


}
