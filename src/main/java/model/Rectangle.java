package model;

import exception.CoordinateException;
import exception.ErrorMessages;


public class Rectangle extends Figure{
    public static final int RECTANGLE_POINT_SIZE = 4;
    private static final int WIDTH_INDEX = 0;
    private static final int HEIGHT_INDEX = 2;

    public Rectangle(Points points) {
        super(points);
        validateRectangle();
    }

    public static Rectangle from(Points points) {
        return new Rectangle(points);
    }

    public void validateRectangle() {
        if (!isRectangle()){
            throw new CoordinateException(ErrorMessages.NOT_RECTANGLE);
        }
    }

    public boolean isRectangle(){
        return linesLength.get(0).equals(linesLength.get(1))
                && linesLength.get(2).equals(linesLength.get(3))
                && linesLength.get(4).equals(linesLength.get(5))
                && !linesLength.get(0).equals(linesLength.get(2));
    }

    @Override
    public double calculateResult() {
        double area = linesLength.get(WIDTH_INDEX) * linesLength.get(HEIGHT_INDEX);
        return roundToSecondDecimal(area);
    }

    @Override
    public String print(double result) {
        return "사각형의 넓이는 " + result;
    }

}
