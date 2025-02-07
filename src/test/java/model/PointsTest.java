package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointsTest {
    @Test
    @DisplayName("Points 객체 생성")
    void from(){
        // given, when
        Points response = Points.from(List.of(24, 5, 3, 15));

        // then
        assertThat(response.getPoint(0)).isEqualTo(Point.of(24, 5));
        assertThat(response.getPoint(1)).isEqualTo(Point.of(3, 15));
    }



    @Test
    @DisplayName("Points 객체 사이즈 반환")
    void size(){
        // given
        Points points = Points.from(List.of(24, 3));

        // when
        int response = points.size();

        // then
        assertThat(response).isEqualTo(1);
    }

}