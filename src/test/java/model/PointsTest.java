package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointsTest {

    @Test
    @DisplayName("문자열로 Points 객체 생성")
    void fromString(){
        // given, when
        Points response = Points.fromString("(10,10)-(22,10)-(22,18)-(10,18)");

        // then
        assertThat(response.getPoint(0)).isEqualTo(Point.of(10, 10));
        assertThat(response.getPoint(1)).isEqualTo(Point.of(22, 10));
        assertThat(response.getPoint(2)).isEqualTo(Point.of(22, 18));
        assertThat(response.getPoint(3)).isEqualTo(Point.of(10, 18));
    }

    @Test
    @DisplayName("Points 객체 추가")
    void addPoint(){
        // given
        Points points = new Points();

        // when
        points.addPoint(24, 0);

        // then
        assertThat(points.getPoint(0)).isEqualTo(Point.of(24, 0));

    }

    @Test
    @DisplayName("Points 객체 사이즈 2 인지 확인해 true 반환")
    void isTwoPoints_true(){
        // given
        Points points = Points.from(Point.of(24, 0), Point.of(0, 24));

        // when
        boolean response = points.isTwoPoints();

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("Points 객체 사이즈 2 인지 확인해 false 반환")
    void isTwoPoints_false(){
        // given
        Points points = new Points();

        // when
        boolean response = points.isTwoPoints();

        // then
        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("Points 객체 사이즈 4 인지 확인해 true 반환")
    void isFourPoints_true(){
        // given
        Points points = new Points();
        for (int i=0; i<4; i++){
            points.addPoint(i, i+1);
        }

        // when
        boolean response = points.isFourPoints();

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("Points 객체 사이즈 4 인지 확인해 false 반환")
    void isFourPoints_false(){
        // given
        Points points = new Points();

        // when
        boolean response = points.isFourPoints();

        // then
        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("Points 객체 사이즈 반환")
    void size(){
        // given
        Points points = new Points();

        // when
        int response = points.size();

        // then
        assertThat(response).isEqualTo(0);
    }

    @Test
    @DisplayName("Points 객체 그래프 그리기")
    void drawPoints(){
        // given
        StringBuilder[] graph = new StringBuilder[2];
        for (int i=0; i<2; i++){
            graph[i] = new StringBuilder().append("    ");
        }

        Points points = new Points(Point.of(0, 24), Point.of(1, 23));

        // when
        points.drawPoints(graph);

        // then
        assertThat(graph[0]).contains("●");
        assertThat(graph[1]).contains("●");

    }
}