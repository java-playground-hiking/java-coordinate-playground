package validator;

import enumclass.FigureType;
import messages.ErrorMessages;
import model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FigureValidatorTest {

//    @Test
//    @DisplayName("입력값 유효성 검사 - 직선")
//    void validateInput_line(){
//        // given, when
//        Points response = scanner.validateInput("(10,10)-(22,10)");
//
//        // then
//        assertThat(response.size()).isEqualTo(2);
//        assertThat(response.getPoint(0)).isEqualTo(Point.of(10, 10));
//        assertThat(response.getPoint(1)).isEqualTo(Point.of(22, 10));
//    }
//
//
//    @Test
//    @DisplayName("입력값 유효성 검사 - 직사각형")
//    void validateInput_rectangle(){
//        // given, when
//        Points response = scanner.validateInput("(10,10)-(22,10)-(22,18)-(10,18)");
//
//        // then
//        assertThat(response.size()).isEqualTo(4);
//        assertThat(response.getPoint(0)).isEqualTo(Point.of(10, 10));
//        assertThat(response.getPoint(1)).isEqualTo(Point.of(22, 10));
//        assertThat(response.getPoint(2)).isEqualTo(Point.of(22, 18));
//        assertThat(response.getPoint(3)).isEqualTo(Point.of(10, 18));
//    }
//
    @Test
    @DisplayName("입력값 패턴 확인 - 직선")
    void validatePattern_line(){
        // given, when
        FigureType response = FigureValidator.validatePattern("(10,10)-(22,10)");

        // then
        assertThat(response).isEqualTo(FigureType.LINE);
    }

    @Test
    @DisplayName("입력값 패턴 맞지 않아 예외 발생 - 직선")
    void InvalidatePattern_line(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> FigureValidator.validatePattern("(10,10)-(22,"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_PATTERN);
    }

    @Test
    @DisplayName("입력값 패턴 확인 - 삼각형")
    void checkMatchPattern_triangle(){
        // given, when
        FigureType response = FigureValidator.validatePattern("(10,10)-(22,10)-(22,18)");

        // then
        assertThat(response).isEqualTo(FigureType.TRIANGLE);
    }


    @Test
    @DisplayName("입력값 패턴 맞지 않아 예외 발생 - 삼각형")
    void misMatchPattern_triangle(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class,
                () -> FigureValidator.validatePattern("(10,10)-(22,10)-(22)"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_PATTERN);
    }

    @Test
    @DisplayName("입력값 패턴 확인 - 사각형")
    void checkMatchPattern_rectangle(){
        // given, when
        FigureType response = FigureValidator.validatePattern("(10,10)-(22,10)-(22,18)-(10,18)");

        // then
        assertThat(response).isEqualTo(FigureType.RECTANGLE);
    }


    @Test
    @DisplayName("입력값 패턴 맞지 않아 예외 발생 - 사각형")
    void misMatchPattern_rectangle(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class,
                () -> FigureValidator.validatePattern("(10,10)-(22,10)-(22,18)-(10,18)-"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_PATTERN);
    }

    @Test
    @DisplayName("직선 정규식 생성")
    void generatePattern_line(){
        // given, when
        String response = FigureValidator.generatePattern(2);

        // then
        assertThat(response).isEqualTo("\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)");
    }

    @Test
    @DisplayName("삼각형 정규식 생성")
    void generatePattern_triangle(){
        // given, when
        String response = FigureValidator.generatePattern(3);

        // then
        assertThat(response).isEqualTo("\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)");
    }

    @Test
    @DisplayName("x, y 좌표 범위 유효성 체크")
    void validateRange(){
        // given, when, then
        assertDoesNotThrow(() -> FigureValidator.validateRange(24, 0));

    }

    @Test
    @DisplayName("x, y 좌표 범위 유효성 체크 시 x 좌표 예외 발생")
    void InvalidateXRange(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> FigureValidator.validateRange(25, 0));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE);
    }

    @Test
    @DisplayName("x, y 좌표 범위 유효성 체크 시 y 좌표 예외 발생")
    void InvalidateYRange(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> FigureValidator.validateRange(24, -1));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RANGE);
    }

    @Test
    @DisplayName("사각형 정규식 생성")
    void generatePattern_rectangle(){
        // given, when
        String response = FigureValidator.generatePattern(4);

        // then
        assertThat(response).isEqualTo("\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)");
    }


    @Test
    @DisplayName("범위 체크 시 true 반환")
    void isCorrectRange_true(){
        // given, when
        boolean response = FigureValidator.isCorrectRange(24);

        // then
        assertThat(response).isTrue();

    }

    @Test
    @DisplayName("범위 체크 시 false 반환")
    void isCorrectRange_false(){
        // given, when
        boolean response = FigureValidator.isCorrectRange(25);

        // then
        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("직사각형 유효성 검사")
    void validateRectangle() {
        // given
        Figure figure = FigureFactory.createFigure(FigureType.RECTANGLE, "(10,10)-(22,10)-(22,18)-(10,18)");
        List<Double> allLength = figure.calculateAllLength();

        // when
        assertDoesNotThrow(() -> FigureValidator.validateRectangle(allLength));
    }

    @Test
    @DisplayName("직사각형 유효성 검사 시 예외 발생")
    void validateRectangle_notRectangle() {
        // given
        List<Double> allLength = List.of(15.0,10.0,20.0,20.0,30.0,30.0);

        // when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> FigureValidator.validateRectangle(allLength));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RECTANGLE);

    }


    @Test
    @DisplayName("직사각형 여부 true 반환")
    void isRectangle_true() {
        // given
        Figure figure = FigureFactory.createFigure(FigureType.RECTANGLE, "(10,10)-(22,10)-(22,18)-(10,18)");
        List<Double> allLength = figure.calculateAllLength();
        // when
        boolean response = FigureValidator.isRectangle(allLength);

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("직사각형 여부 false 반환")
    void isRectangle_false() {
        // given
        List<Double> allLength = List.of(15.0,10.0,20.0,20.0,30.0,30.0);

        // when
        boolean response = FigureValidator.isRectangle(allLength);


        // then
        assertThat(response).isFalse();
    }

}