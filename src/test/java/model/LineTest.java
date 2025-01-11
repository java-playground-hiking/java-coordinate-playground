package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    private Line line;

    @BeforeEach
    void setUp(){
        line = Line.of(Point.of(10, 10), Point.of(14, 15));
    }


    @Test
    @DisplayName("길이 계산")
    void calculateLength(){
        // given, when
        double response = line.calculateLength();

        // then
        assertThat(response).isEqualTo(6.4031242374328485);
    }

    @Test
    @DisplayName("x 좌표 뺄셈")
    void minusX(){
        // given, when
        double response = line.minusX();

        // then
        assertThat(response).isEqualTo(-4);
    }

    @Test
    @DisplayName("y 좌표 뺄셈")
    void minusY(){
        // given, when
        double response = line.minusY();

        // then
        assertThat(response).isEqualTo(-5);
    }

    @Test
    @DisplayName("2배수")
    void powOfTwo(){
        // given, when
        double response = line.powOfTwo(4);

        // then
        assertThat(response).isEqualTo(16);
    }


}