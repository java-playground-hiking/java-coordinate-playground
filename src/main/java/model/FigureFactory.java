package model;

import enumclass.FigureType;
import util.CoordinateUtils;

import java.util.List;

public class FigureFactory {

    public static Figure createFigure(FigureType type, String input){
        List<Integer> numbers = CoordinateUtils.splitStringToInteger(input);
        Points points = Points.from(numbers);
        return type.of(points);
    }

}
