package abs;

import message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AvanteTest {

    @Test
    @DisplayName("자동차 거리 입력 값 유효성 체크")
    void validDistance(){
        // given, when, then
        assertDoesNotThrow(() -> new Avante(150));
    }

    @Test
    @DisplayName("자동차 거리 입력 값 유효성 체크 시 음수 입력한 경우")
    void validDistanceInputMinus(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> new Avante(-150));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NEGATIVE_INPUT);
    }

    @Test
    @DisplayName("자동차 이름 반환")
    void getCarName(){
        // given
        RentCar avante = new Avante(150);

        // when
        String response = avante.getCarName();

        // then
        assertThat(response).isEqualTo("Avante");
    }

    @Test
    @DisplayName("자동차 연비 반환")
    void getFuelEfficiency(){
        // given
        RentCar avante = new Avante(150);

        // when
        int response = avante.getFuelEfficiency();

        // then
        assertThat(response).isEqualTo(15);
    }

    @Test
    @DisplayName("자동차 연료량 계산")
    void calculate(){
        // given
        RentCar avante = new Avante(150);

        // when
        int response = avante.calculate();

        // then
        assertThat(response).isEqualTo(10);
    }

    @Test
    @DisplayName("자동차 연료량 계산 시 0 입력한 경우")
    void calculateInputZero(){
        // given
        RentCar avante = new Avante(0);

        // when
        int response = avante.calculate();

        // then
        assertThat(response).isEqualTo(0);
    }



}