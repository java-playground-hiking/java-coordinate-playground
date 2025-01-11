package model;

import messages.ErrorMessages;

import java.util.List;

public class Rectangle {
    private static final int WIDTH_INDEX = 0;
    private static final int HEIGHT_INDEX = 2;

    private Lines lines;
    private List<Double> linesLength;

    public Rectangle(Points points){
        this.lines = new Lines(points);
        this.linesLength = lines.allSortedLinesLength();
    }

    public double calculateArea(){
        return linesLength.get(WIDTH_INDEX) * linesLength.get(HEIGHT_INDEX);
    }

    public void validateRectangle(){
        if (!isRectangle()){
            throw new IllegalArgumentException(ErrorMessages.INVALID_RECTANGLE);
        }
    }

    public boolean isRectangle(){
        return linesLength.get(0).equals(linesLength.get(1))
                && linesLength.get(2).equals(linesLength.get(3))
                && linesLength.get(4).equals(linesLength.get(5))
                && !linesLength.get(0).equals(linesLength.get(2));
    }

}
