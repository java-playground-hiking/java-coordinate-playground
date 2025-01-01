package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {

    @Test
    @DisplayName("x 좌표 거리 계산")
    void minusX(){
        // given
        Points points = new Points(Point.from(10.0, 10.0), Point.from(14.0, 15.0));

        // when
        double response = points.minusX();

        // then
        assertThat(response).isEqualTo(-4.0);
    }

    @Test
    @DisplayName("y 좌표 거리 계산")
    void minusY(){
        // given
        Points points = new Points(Point.from(10.0, 10.0), Point.from(14.0, 15.0));

        // when
        double response = points.minusY();

        // then
        assertThat(response).isEqualTo(-5.0);
    }

    @Test
    @DisplayName("점 2개 다 y 값 같은 좌표 그림 생성")
    void drawPoints_pointsMatchY(){
        // given
        Points points = new Points(Point.from(2.0, 1.0), Point.from(3.0, 1.0));
        StringBuilder sb = new StringBuilder();

        // when
        points.drawPoints(1, sb);

        // then
        assertThat(sb.toString()).isEqualTo("      ㆍ   ㆍ");
    }


    @Test
    @DisplayName("점 1개만 y 값이 같은 그림 생성")
    void drawPoints_pointMatchY(){
        // given
        Points points = new Points(Point.from(2.0, 1.0), Point.from(3.0, 2.0));
        StringBuilder sb = new StringBuilder();

        // when
        points.drawPoints(1, sb);

        // then
        assertThat(sb.toString()).isEqualTo("      ㆍ");
    }

    @Test
    @DisplayName("모든 점이 y 값과 다른 경우")
    void drawPoints_pointsNotMatchY(){
        // given
        Points points = new Points(Point.from(2.0, 1.0), Point.from(3.0, 2.0));
        StringBuilder sb = new StringBuilder();

        // when
        points.drawPoints(10, sb);

        // then
        assertThat(sb.isEmpty()).isTrue();
    }


}