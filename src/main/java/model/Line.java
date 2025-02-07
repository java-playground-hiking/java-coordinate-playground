package model;

public class Line extends Figure{

    public Line(Points points){
        super(points);
    }

    @Override
    public double calculateResult() {
        double distance = calculateDistance(points.getPoint(0), points.getPoint(1));
        return Math.round(distance * 100.0) / 100.0;
    }

    @Override
    public String printResult(double result) {
        return "두 점 사이 거리는 " + result;
    }

}
