package io;

import messages.ErrorMessages;
import model.Point;
import model.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputScannerTest {

    private InputScanner scanner;

    @BeforeEach
    void setUp(){
        scanner = new InputScanner();
    }

    @Test
    @DisplayName("입력값 유효성 검사 - 직선")
    void validateInput_line(){
        // given, when
        Points response = scanner.validateInput("(10,10)-(22,10)");

        // then
        assertThat(response.size()).isEqualTo(2);
        assertThat(response.getPoint(0)).isEqualTo(Point.of(10, 10));
        assertThat(response.getPoint(1)).isEqualTo(Point.of(22, 10));
    }


    @Test
    @DisplayName("입력값 유효성 검사 - 직사각형")
    void validateInput_rectangle(){
        // given, when
        Points response = scanner.validateInput("(10,10)-(22,10)-(22,18)-(10,18)");

        // then
        assertThat(response.size()).isEqualTo(4);
        assertThat(response.getPoint(0)).isEqualTo(Point.of(10, 10));
        assertThat(response.getPoint(1)).isEqualTo(Point.of(22, 10));
        assertThat(response.getPoint(2)).isEqualTo(Point.of(22, 18));
        assertThat(response.getPoint(3)).isEqualTo(Point.of(10, 18));
    }

    @Test
    @DisplayName("입력값 패턴 확인 - 직선")
    void checkMatchPattern_line(){
        // given, when, then
        assertDoesNotThrow(() -> scanner.checkMatchPattern("(10,10)-(22,10)"));
    }

    @Test
    @DisplayName("입력값 패턴 확인 - 사각형")
    void checkMatchPattern_rectangle(){
        // given, when, then
        assertDoesNotThrow(() -> scanner.checkMatchPattern("(10,10)-(22,10)-(22,18)-(10,18)"));
    }


    @Test
    @DisplayName("입력값 패턴 맞지 않아 예외 발생 - 직선")
    void misMatchPattern_line(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> scanner.checkMatchPattern("(10,10)-(22,"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_PATTERN);
    }

    @Test
    @DisplayName("입력값 패턴 맞지 않아 예외 발생 - 사각형")
    void misMatchPattern_rectangle(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> scanner.checkMatchPattern("(10,10)-(22,10)-(22,18)-(10,18)-"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_PATTERN);
    }

    @Test
    @DisplayName("직선 패턴 확인 시 true 반환")
    void isMatchTwoPoints_true(){
        // given, when
        boolean response = scanner.isMatchTwoPoints("(10,10)-(22,10)");

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("직선 패턴 확인 시 false 반환")
    void isMatchTwoPoints_false(){
        // given, when
        boolean response = scanner.isMatchTwoPoints("(10,10)-(22,10");

        // then
        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("직사각형 패턴 확인 시 true 반환")
    void isMatchFourPoints_true(){
        // given, when
        boolean response = scanner.isMatchFourPoints("(10,10)-(22,10)-(22,18)-(10,18)");

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("직사각형 패턴 확인 시 false 반환")
    void isMatchFourPoints_false(){
        // given, when
        boolean response = scanner.isMatchFourPoints("(10,10)-(22,10)-(22,18)-(10,1");

        // then
        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("직사각형 유효성 검사")
    void checkRectangleShapes(){
        // given
        Points points = new Points();
        points.addPoint(10, 10);
        points.addPoint(22, 10);
        points.addPoint(22, 18);
        points.addPoint(10, 18);

        // when, then
        assertDoesNotThrow(() -> scanner.checkRectangleShapes(points));
    }


    @Test
    @DisplayName("직사각형이 아닌 경우 유효성 검사 실행 안함")
    void checkRectangleShapes_line(){
        // given
        Points points = new Points();
        points.addPoint(10, 10);
        points.addPoint(22, 10);

        // when, then
        assertDoesNotThrow(() -> scanner.checkRectangleShapes(points));
    }

    @Test
    @DisplayName("직사각형 유효성 검사 시 마름모로 예외 발생")
    void checkRectangleShapes_diamond(){
        // given
        Points points = new Points();
        points.addPoint(12, 6);
        points.addPoint(18, 18);
        points.addPoint(6, 18);
        points.addPoint(0, 6);

        // when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> scanner.checkRectangleShapes(points));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RECTANGLE);

    }

    @Test
    @DisplayName("직사각형 유효성 검사 시 직사각형이 아닌 도형으로 예외 발생")
    void checkRectangleShapes_notRectangle(){
        // given
        Points points = new Points();
        points.addPoint(3,5);
        points.addPoint(7,14);
        points.addPoint(15,18);
        points.addPoint(21,3);

        // when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> scanner.checkRectangleShapes(points));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RECTANGLE);

    }

}