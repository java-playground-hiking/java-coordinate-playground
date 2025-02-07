package util;

import messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateUtilsTest {

    @Test
    @DisplayName("문자열 숫자로 변환")
    void parseInteger(){
        // given, when
        Integer response = CoordinateUtils.parseInteger("13");

        // then
        assertThat(response).isEqualTo(13);
    }

    @Test
    @DisplayName("문자열 숫자로 변환 시 예외 발생")
    void parseIntegerNotNumber(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> CoordinateUtils.parseInteger("문자열"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NUMBER);
    }

    @Test
    @DisplayName("문자열 숫자 리스트로 변환 - 직선")
    void splitStringToInteger1(){
        // given, when
        List<Integer> response = CoordinateUtils.splitStringToInteger("(10,10)-(22,10)");

        // then
        assertThat(response.size()).isEqualTo(4);
        assertThat(response.get(0)).isEqualTo(10);
        assertThat(response.get(1)).isEqualTo(10);
        assertThat(response.get(2)).isEqualTo(22);
        assertThat(response.get(3)).isEqualTo(10);
    }

    @Test
    @DisplayName("문자열 숫자 리스트로 변환 - 직사각형")
    void splitStringToInteger2(){
        // given, when
        List<Integer> response = CoordinateUtils.splitStringToInteger("(10,10)-(22,10)-(22,18)-(10,18)");

        // then
        assertThat(response.size()).isEqualTo(8);
        assertThat(response.get(0)).isEqualTo(10);
        assertThat(response.get(1)).isEqualTo(10);
        assertThat(response.get(2)).isEqualTo(22);
        assertThat(response.get(3)).isEqualTo(10);
    }

    @Test
    @DisplayName("문자열 숫자 리스트로 변환 시 숫자가 아닌 값으로 인해 리스트 사이즈 0")
    void splitStringToIntegerNotNumber(){
        // given, when
        List<Integer> response = CoordinateUtils.splitStringToInteger("문자열");

        // then
        assertThat(response.size()).isEqualTo(0);
    }

}