package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private Line line;

    @BeforeEach
    void setUp(){
        Points points = Points.from(List.of(10, 10, 14, 15));
        line = new Line(points);
    }

    @Test
    @DisplayName("거리 계산")
    void calculateResult(){
        // given, when
        double response = line.calculateResult();

        // then
        assertThat(response).isEqualTo(6.4);
    }

    @Test
    @DisplayName("계산 결과 출력")
    void printResult(){
        // given, when
        String response = line.printResult(6.4);

        // then
        assertThat(response).isEqualTo("두 점 사이 거리는 6.4");
    }


}