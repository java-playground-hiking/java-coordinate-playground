package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TriangleTest {

    @Test
    @DisplayName("삼각형 생성")
    void from(){
        // given
        Points points = Points.from(List.of(10, 0, 24, 15));

        // when
        // then
        assertDoesNotThrow(() -> Triangle.from(points));
    }

    @Test
    @DisplayName("삼각형 넓이 계산")
    void calculateResult(){
        // given
        Points points = Points.from(List.of(10, 10, 14, 15, 20, 8));
        Figure triangle = Triangle.from(points);

        // when
        double response = triangle.calculateResult();

        // then
        assertThat(response).isEqualTo(29.0);
    }

    @Test
    @DisplayName("삼각형 넓이 출력")
    void print(){
        // given
        Points points = Points.from(List.of(10, 10, 14, 15, 20, 8));
        Figure triangle = Triangle.from(points);

        // when
        String response =  triangle.print(29.0);

        // then
        assertThat(response).isEqualTo("삼각형의 넓이는 29.0");
    }
}
