package model;

import enumclass.FigureType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FigureTest {

    @Test
    @DisplayName("모든 선의 길이 계산 - Line")
    void calculateAllLength_line(){
        // given
        Figure figure = FigureFactory.createFigure(FigureType.LINE, "(10,10)-(14,15)");

        // when
        List<Double> response = figure.calculateAllLength();

        // then
        assertThat(response.size()).isEqualTo(1);
        assertThat(response.get(0)).isEqualTo(6.4031242374328485);
    }

    @Test
    @DisplayName("모든 선의 길이 계산 - Triangle")
    void calculateAllLength_triangle(){
        // given
        Figure figure = FigureFactory.createFigure(FigureType.TRIANGLE, "(10,10)-(14,15)-(24,0)");

        // when
        List<Double> response = figure.calculateAllLength();

        // then
        assertThat(response.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("모든 선의 길이 계산 - Rectangle")
    void calculateAllLength_rectangle(){
        // given
        Figure figure = FigureFactory.createFigure(FigureType.RECTANGLE, "(10,10)-(22,10)-(22,18)-(10,18)");

        // when
        List<Double> response = figure.calculateAllLength();

        // then
        assertThat(response.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("길이 계산")
    void calculateLength(){
        // given
        Figure figure = FigureFactory.createFigure(FigureType.LINE, "(10,10)-(14,15)");

        // when
        double response = figure.calculateDistance(new Point(10, 10), new Point(14, 15));

        // then
        assertThat(response).isEqualTo(6.4031242374328485);
    }


}