package model;

import messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    @DisplayName("넓이 계산")
    void calculateArea(){
        // given
        Points points = new Points();
        points.addPoint(10, 10);
        points.addPoint(22, 10);
        points.addPoint(22, 18);
        points.addPoint(10, 18);

        Rectangle rectangle = new Rectangle(points);

        // when
        double response = rectangle.calculateArea();

        // then
        assertThat(response).isEqualTo(96.0);
    }

    @Test
    @DisplayName("직사각형 유효성 검사")
    void validateRectangle(){
        // given
        Points points = new Points();
        points.addPoint(10, 10);
        points.addPoint(22, 10);
        points.addPoint(22, 18);
        points.addPoint(10, 18);

        Rectangle rectangle = new Rectangle(points);

        // when
        assertDoesNotThrow(rectangle::validateRectangle);
    }

    @Test
    @DisplayName("직사각형 유효성 검사로 예외 발생")
    void invalidateRectangle(){
        // given
        Points points = new Points();
        points.addPoint(0, 0);
        points.addPoint(22, 10);
        points.addPoint(22, 18);
        points.addPoint(10, 18);

        Rectangle rectangle = new Rectangle(points);

        // when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, rectangle::validateRectangle);

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_RECTANGLE);
    }

    @Test
    @DisplayName("직사각형 여부 true 반환")
    void isRectangle_true(){
        // given
        Points points = new Points();
        points.addPoint(10, 10);
        points.addPoint(22, 10);
        points.addPoint(22, 18);
        points.addPoint(10, 18);

        Rectangle rectangle = new Rectangle(points);

        // when
        boolean response = rectangle.isRectangle();

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("직사각형 여부 false 반환")
    void isRectangle_false(){
        // given
        Points points = new Points();
        points.addPoint(0, 0);
        points.addPoint(22, 10);
        points.addPoint(22, 18);
        points.addPoint(10, 18);

        Rectangle rectangle = new Rectangle(points);

        // when
        boolean response = rectangle.isRectangle();

        // then
        assertThat(response).isFalse();
    }



}