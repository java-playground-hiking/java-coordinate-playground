package utils;

import exception.CoordinateException;
import exception.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoordinateUtilsTest {

    @Test
    @DisplayName("문자열 숫자 분리")
    void splitNumbers1(){
        // given
        String request = "(10,10)-(14,15)";

        // when
        List<Integer> response = CoordinateUtils.splitNumbers(request);

        // then
        assertThat(response.size()).isEqualTo(4);
        assertThat(response.get(0)).isEqualTo(10);
        assertThat(response.get(2)).isEqualTo(14);
    }

    @Test
    @DisplayName("문자열 숫자 분리")
    void splitNumbers2(){
        // given
        String request = "(10,10)-(22,10)-(22,18)";

        // when
        List<Integer> response = CoordinateUtils.splitNumbers(request);

        // then
        assertThat(response.size()).isEqualTo(6);
        assertThat(response.get(0)).isEqualTo(10);
        assertThat(response.get(2)).isEqualTo(22);
    }

    @Test
    @DisplayName("문자열 숫자 분리")
    void splitNumbers3(){
        // given
        String request = "(10,10)-(22,10)-(22,18)-(10,18)";

        // when
        List<Integer> response = CoordinateUtils.splitNumbers(request);

        // then
        assertThat(response.size()).isEqualTo(8);
        assertThat(response.get(0)).isEqualTo(10);
        assertThat(response.get(2)).isEqualTo(22);
    }

    @Test
    @DisplayName("문자열 숫자를 정수로 변경")
    void convertStringToInteger(){
        // given
        // when
        int response = CoordinateUtils.convertStringToInteger("3");

        // then
        assertThat(response).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 숫자를 정수로 변경 시 예외 발생")
    void convertStringToInteger_exception(){
        // given
        // when
        // then
        assertThatThrownBy(() -> CoordinateUtils.convertStringToInteger("3^"))
                .isInstanceOf(CoordinateException.class)
                .hasMessage(ErrorMessages.INVALID_INPUT_NUMBER);

    }
}
