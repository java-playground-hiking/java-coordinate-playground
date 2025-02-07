package model;

import enumclass.FigureType;
import messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.FigureValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FigureFactoryTest {

    @Test
    @DisplayName("Line 객체 생성")
    void createFigureLine(){
        // given, when
        Figure response = FigureFactory.createFigure(FigureType.LINE, "(10,0)-(24,10)");

        // then
        assertThat(response.points.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Triangle 객체 생성")
    void createFigureTriangle(){
        // given, when
        Figure response = FigureFactory.createFigure(FigureType.TRIANGLE, "(10,0)-(24,10)-(14,15)");

        assertThat(response.points.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Rectangle 객체 생성")
    void createFigureRectangle(){
        // given, when
        Figure response = FigureFactory.createFigure(FigureType.TRIANGLE, "(10,0)-(24,10)-(14,15)-(5,20)");

        assertThat(response.points.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("직사각형 유효성 검사 시 마름모로 예외 발생")
    void createFigureRectangle_diamond() {
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class,
                () -> FigureFactory.createFigure(FigureType.RECTANGLE, "(12,6)-(18,18)-(6,18)-(0,6)"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RECTANGLE);

    }


    @Test
    @DisplayName("직사각형 유효성 검사 시 직사각형이 아닌 도형으로 예외 발생")
    void checkRectangleShapes_notRectangle() {
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class,
                () -> FigureFactory.createFigure(FigureType.RECTANGLE, "(3,5)-(7,14)-(15,18)-(21,3)"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RECTANGLE);
    }
}