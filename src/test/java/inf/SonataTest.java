package inf;

import message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SonataTest {

    @Test
    @DisplayName("자동차 거리 입력 값 유효성 체크")
    void validDistance(){
        // given, when, then
        assertDoesNotThrow(() -> new Sonata(100));
    }

    @Test
    @DisplayName("자동차 거리 입력 값 유효성 체크 시 음수 입력한 경우")
    void validDistanceInputMinus(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> new Sonata(-100));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NEGATIVE_INPUT);
    }

    @Test
    @DisplayName("자동차 연비 계산")
    void calculate(){
        // given
        RentCar sonata = new Sonata(100);

        // when
        int response = sonata.calculate();

        // then
        assertThat(response).isEqualTo(10);
    }

    @Test
    @DisplayName("자동차 연비 계산 시 거리 0 입력한 경우")
    void calculateInputZero(){
        // given
        RentCar sonata = new Sonata(0);

        // when
        int response = sonata.calculate();

        // then
        assertThat(response).isEqualTo(0);
    }



}