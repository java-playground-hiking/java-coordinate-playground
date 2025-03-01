package model;

public class Line extends Figure {
    public static final int LINE_POINT_SIZE = 2;

    public Line(Points points){
        super(points);
    }

    public static Line from(Points points) {
        return new Line(points);
    }

    @Override
    public double calculateResult() {
        double distance = linesLength.get(0);
        return roundToSecondDecimal(distance);
    }

    @Override
    public String print(double result) {
        return "두 점 사이 거리는 " + result;
    }



}
