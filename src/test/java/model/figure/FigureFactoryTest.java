package model.figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.CoordinateStringReader;
import model.coordinate.Coordinates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FigureFactoryTest {

    @Test
    @DisplayName("두 개의 좌표를 입력하면 선 도형을 생성한다")
    void lineCreate() {
        Coordinates coordinates = CoordinateStringReader.from("(10,10)-(14,15)").getCoordinates();

        assertThat(FigureFactory.create(coordinates)).isEqualTo(Line.from(coordinates.toPoints()));
    }

    @Test
    @DisplayName("네 개의 좌표를 입력하면 사각형 도형을 생성한다")
    void rectangleCreate() {
        Coordinates coordinates = CoordinateStringReader.from("(10,10)-(22,10)-(22,18)-(10,18)").getCoordinates();

        assertThat(FigureFactory.create(coordinates)).isEqualTo(Rectangle.from(coordinates.toPoints()));
    }

    @Test
    @DisplayName("세 개의 좌표를 입력하면 삼각형 도형을 생성한다")
    void triangleCreate() {
        Coordinates coordinates = CoordinateStringReader.from("(10,10)-(14,15)-(20,8)").getCoordinates();

        assertThat(FigureFactory.create(coordinates)).isEqualTo(Triangle.from(coordinates.toPoints()));
    }

    @Test
    @DisplayName("등록되지 않은 도형의 좌표 갯 수를 입력하면 에러가 발생한다")
    void createFailed() {
        Coordinates coordinates = CoordinateStringReader.from("(10,10)-(10,10)-(14,15)-(20,8)-(10,18)").getCoordinates();

        assertThatThrownBy(() -> {
            FigureFactory.create(coordinates);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
