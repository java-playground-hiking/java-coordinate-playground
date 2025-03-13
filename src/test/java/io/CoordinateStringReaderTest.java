package io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.coordinate.Coordinate;
import model.coordinate.Coordinates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinateStringReaderTest {

    @Test
    @DisplayName("유저가 문자열로 형식에 맞는 좌표 값을 입력하면 숫자 좌표로 변환한다")
    void userInputCreate() {
        String userInput = "(10,10)-(14,15)";

        CoordinateStringReader coordinateStringReader = CoordinateStringReader.from(userInput);

        assertThat(coordinateStringReader.getCoordinates()).isEqualTo(
                Coordinates.from(List.of(Coordinate.of(10, 10), Coordinate.of(14, 15))));
    }

    @Test
    @DisplayName("유저가 입력한 좌표가 한 개 이하라면 좌표 생성 오류가 발생한다")
    void invalidUserInput() {
        String userInput = "(10,10)";

        assertThatThrownBy(() -> {
            CoordinateStringReader.from(userInput)
                    .getCoordinates();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("두 개 이상의 좌표를 입력해야 합니다.");
    }

}
