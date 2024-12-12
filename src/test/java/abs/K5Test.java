package abs;

import message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class K5Test {
    @Test
    @DisplayName("자동차 거리 입력 값 유효성 체크")
    void validDistance(){
        // given, when, then
        assertDoesNotThrow(() -> new K5(130));
    }

    @Test
    @DisplayName("자동차 거리 입력 값 유효성 체크 시 음수 입력한 경우")
    void validDistanceInputMinus(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> new K5(-130));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NEGATIVE_INPUT);
    }

    @Test
    @DisplayName("자동차 이름 반환")
    void getCarName(){
        // given
        RentCar k5 = new K5(130);

        // when
        String response = k5.getCarName();

        // then
        assertThat(response).isEqualTo("K5");
    }

    @Test
    @DisplayName("자동차 연비 반환")
    void getFuelEfficiency(){
        // given
        RentCar k5 = new K5(130);

        // when
        int response = k5.getFuelEfficiency();

        // then
        assertThat(response).isEqualTo(13);
    }

    @Test
    @DisplayName("자동차 연료량 계산")
    void calculate(){
        // given
        RentCar k5 = new K5(130);

        // when
        int response = k5.calculate();

        // then
        assertThat(response).isEqualTo(10);
    }

    @Test
    @DisplayName("자동차 연료량 계산 시 0 입력한 경우")
    void calculateInputZero(){
        // given
        RentCar k5 = new K5(0);

        // when
        int response = k5.calculate();

        // then
        assertThat(response).isEqualTo(0);
    }
}