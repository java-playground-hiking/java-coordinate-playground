package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {

    @Test
    @DisplayName("직선 객체 생성")
    void from(){
        // given
        Points points = Points.from(List.of(10, 0, 24, 15));

        // when
        // then
        assertDoesNotThrow(() -> Line.from(points));
    }

    @Test
    @DisplayName("두 점 사이 거리 계산")
    void calculateResult(){
        // given
        Points points = Points.from(List.of(10, 10, 14, 15));
        Figure line = Line.from(points);

        // when
        double response = line.calculateResult();

        // then
        assertThat(response).isEqualTo(6.40);
    }

    @Test
    @DisplayName("두 점 사이 거리 출력")
    void print(){
        // given
        Points points = Points.from(List.of(10, 10, 14, 15));
        Figure line = Line.from(points);

        // when
        String response = line.print(6.4);

        // then
        assertThat(response).isEqualTo("두 점 사이 거리는 6.4");
    }


}
