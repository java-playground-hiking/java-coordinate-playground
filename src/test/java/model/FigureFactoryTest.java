package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureFactoryTest {


    @Test
    @DisplayName("선 객체 생성")
    void line(){
        // given
        List<Integer> numbers = List.of(10, 10, 14, 15);

        // when
        Figure figure = new FigureFactory().create(numbers);

        // then
        assertThat(figure).isInstanceOf(Line.class);
        assertThat(figure.points.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("삼각형 객체 생성")
    void triangle(){
        // given
        List<Integer> numbers = List.of(10, 10, 22, 10, 22, 18);

        // when
        Figure figure = new FigureFactory().create(numbers);

        // then
        assertThat(figure).isInstanceOf(Triangle.class);
        assertThat(figure.points.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사각형 객체 생성")
    void rectangle(){
        // given
        List<Integer> numbers = List.of(10, 10, 22, 10, 22, 18, 10, 18);

        // when
        Figure figure = new FigureFactory().create(numbers);

        // then
        assertThat(figure).isInstanceOf(Rectangle.class);
        assertThat(figure.points.size()).isEqualTo(4);
    }
}
