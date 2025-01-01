package util;

import messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilTest {
    @Test
    @DisplayName("문자열 Double 로 변경")
    void parseDouble(){
        // given, when
        double response = StringUtil.parseDouble("10");

        // then
        assertThat(response).isEqualTo(10.0);
    }

    @Test
    @DisplayName("문자열 Double 로 변경 시 예외 발생")
    void parseDoubleException(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> StringUtil.parseDouble("입력"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NUMBER_INPUT);
    }

}