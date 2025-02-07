package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleTest {

    private Rectangle rectangle;

    @BeforeEach
    void setUp(){
        Points points = Points.from(List.of(10,10,22,10,22,18,10,18));
        rectangle = new Rectangle(points);
    }

    @Test
    @DisplayName("넓이 계산")
    void calculateResult(){
        // given, when
        double response = rectangle.calculateResult();

        // then
        assertThat(response).isEqualTo(96.0);
    }

    @Test
    @DisplayName("계산 결과 출력")
    void printResult(){
        // given, when
        String response = rectangle.printResult(96.0);

        // then
        assertThat(response).isEqualTo("사각형의 넓이는 96.0");
    }




}