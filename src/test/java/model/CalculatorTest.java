package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("거리 계산")
    void distance(){
        // given
        Point point1 = Point.from(10.0, 10.0);
        Point point2 = Point.from(14.0, 15.0);
        Points points = new Points(point1, point2);

        Calculator calculator = new Calculator(points);

        // when
        double response = calculator.distance();

        // then
        assertThat(response).isEqualTo(6.4031242374328485);
    }

    @Test
    @DisplayName("거리 계산 시 점 좌표가 0인 경우")
    void distancePointZero(){
        // given
        Point point1 = Point.from(0.0, 0.0);
        Point point2 = Point.from(14.0, 15.0);
        Points points = new Points(point1, point2);

        Calculator calculator = new Calculator(points);

        // when
        double response = calculator.distance();

        // then
        assertThat(response).isEqualTo(20.518284528683193);
    }

    @Test
    @DisplayName("거리 계산 시 점 좌표가 전부 0인 경우")
    void distancePointAllZero(){
        // given
        Point point1 = Point.from(0.0, 0.0);
        Point point2 = Point.from(0.0, 0.0);
        Points points = new Points(point1, point2);

        Calculator calculator = new Calculator(points);

        // when
        double response = calculator.distance();

        // then
        assertThat(response).isEqualTo(0.0);
    }

    @Test
    @DisplayName("제곱 연산")
    void powOfTwo(){
        // given
        Points points = new Points(Point.from(10.0, 10.0), Point.from(14.0, 15.0));
        Calculator calculator = new Calculator(points);

        // when
        double response = calculator.powOfTwo(5.0);

        // then
        assertThat(response).isEqualTo(25.0);
    }

    @Test
    @DisplayName("제곱근 연산")
    void plusAndSquareRoot(){
        // given
        Points points = new Points(Point.from(10.0, 10.0), Point.from(14.0, 15.0));
        Calculator calculator = new Calculator(points);

        // when
        double response = calculator.plusAndSquareRoot(4.0, 5.0);

        // then
        assertThat(response).isEqualTo(3.0);
    }
}
