package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private Triangle triangle;

    @BeforeEach
    void setUp(){
        Points points = Points.from(List.of(10,10,14,15,20,8));
        triangle = new Triangle(points);
    }

    @Test
    @DisplayName("넓이 계산")
    void calculateResult(){
        // given, when
        double response = triangle.calculateResult();

        // then
        assertThat(response).isEqualTo(29.0);
    }

    @Test
    @DisplayName("계산 결과 출력")
    void printResult(){
        // given, when
        String response = triangle.printResult(29.0);

        // then
        assertThat(response).isEqualTo("삼각형의 넓이는 29.0");
    }


}