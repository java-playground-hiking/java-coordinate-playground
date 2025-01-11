package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("직선 길이 구하기")
    void calculate_line(){
        // given
        Points points = new Points();
        points.addPoint(10, 10);
        points.addPoint(14, 15);

        Calculator calculator = new Calculator(points);

        // when
        double response = calculator.calculate();

        // then
        assertThat(response).isEqualTo(6.4031242374328485);
    }

    @Test
    @DisplayName("직사각형 넓이 구하기")
    void calculate_rectangle(){
        // given
        Points points = new Points();
        points.addPoint(10, 10);
        points.addPoint(22, 10);
        points.addPoint(22, 18);
        points.addPoint(10, 18);

        Calculator calculator = new Calculator(points);

        // when
        double response = calculator.calculate();

        // then
        assertThat(response).isEqualTo(96);
    }

}