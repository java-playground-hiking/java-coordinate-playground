package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinesTest {


    @Test
    @DisplayName("Points 객체(size 4) 이용해 가능한 Line 리스트 생성")
    void createAllLines1(){
        // given
        Points points = new Points();
        for (int i=0; i<4; i++){
            points.addPoint(i, i+1);
        }

        Lines lines = new Lines(points);

        // when
        List<Line> response = lines.createAllLines();

        // then
        assertThat(response.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Points 객체(size 2) 이용해 가능한 Line 리스트 생성")
    void createAllLines2(){
        // given
        Points points = new Points();
        for (int i=0; i<2; i++){
            points.addPoint(i, i+1);
        }

        Lines lines = new Lines(points);

        // when
        List<Line> response = lines.createAllLines();

        // then
        assertThat(response.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Points 객체를 이용해 가능한 모든 Line 조합 생성")
    void allLineForPoints(){
        // given
        Points points = new Points();
        for (int i=0; i<4; i++){
            points.addPoint(i, i+1);
        }

        Lines lines = new Lines(points);
        List<Line> lineList = new ArrayList<>();

        // when
        lines.allLineForPoints(points, lineList, 2);

        // then
        assertThat(lineList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("모든 Line 길이 계산해서 오름차순으로 정렬")
    void allSortedLinesLength(){
        // given
        Points points = new Points();
        for (int i=0; i<4; i++){
            points.addPoint(i, i+1);
        }

        Lines lines = new Lines(points);

        // when
        List<Double> response = lines.allSortedLinesLength();

        // then
        assertThat(response.size()).isEqualTo(6);
        assertThat(response.get(1)).isGreaterThanOrEqualTo(response.get(0));
    }

}