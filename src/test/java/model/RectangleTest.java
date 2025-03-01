package model;

import exception.CoordinateException;
import exception.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    @Test
    @DisplayName("직사각형 생성")
    void from(){
        // given
        Points points = Points.from(List.of(10, 10, 22, 10, 22, 18, 10, 18));

        // when
        // then
        assertDoesNotThrow(() -> Rectangle.from(points));
    }

    @Test
    @DisplayName("직사각형이 아니여서 예외 발생")
    void from_notRectangle(){
        // given
        Points points = Points.from(List.of(3, 5, 7, 14, 22, 18, 10, 18));

        // when
        CoordinateException fail = assertThrows(CoordinateException.class, () -> Rectangle.from(points));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.NOT_RECTANGLE);
    }

    @Test
    @DisplayName("사각형 넓이 계산")
    void calculateResult(){
        // given
        Points points = Points.from(List.of(10, 10, 22, 10, 22, 18, 10, 18));
        Figure rectangle = Rectangle.from(points);

        // when
        double response = rectangle.calculateResult();

        // then
        assertThat(response).isEqualTo(96.0);
    }

    @Test
    @DisplayName("사각형 넓이 출력")
    void print(){
        // given
        Points points = Points.from(List.of(10, 10, 22, 10, 22, 18, 10, 18));
        Figure rectangle = Rectangle.from(points);

        // when
        String response = rectangle.print(96.0);

        // then
        assertThat(response).isEqualTo("사각형의 넓이는 96.0");
    }

}
