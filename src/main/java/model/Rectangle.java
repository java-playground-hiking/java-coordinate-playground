package model;

import messages.ErrorMessages;
import validator.FigureValidator;

import java.util.List;

public class Rectangle extends Figure{
    private static final int WIDTH_INDEX = 0;
    private static final int HEIGHT_INDEX = 2;

    private List<Double> linesLength;

    public Rectangle(Points points) {
        super(points);
        this.linesLength = calculateAllLength();
        FigureValidator.validateRectangle(linesLength);
    }


    @Override
    public double calculateResult() {
        double area = linesLength.get(WIDTH_INDEX) * linesLength.get(HEIGHT_INDEX);
        return Math.round(area * 100.0) / 100.0;
    }

    @Override
    public String printResult(double result) {
        return "사각형의 넓이는 " + result;
    }



}
