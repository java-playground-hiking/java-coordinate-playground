package model;

public class Calculator {
    public static final int SQUARE_EXPONENT = 2;

    private final Points points;

    public Calculator(Points points){
        this.points = points;
    }

    public double distance(){
        // 제곱근((A.x - B.x)^제곱 + (A.y - B.y)^제곱)
        double xDistance = powOfTwo(points.minusX());
        double yDistance = powOfTwo(points.minusY());

        return plusAndSquareRoot(xDistance, yDistance);
    }

    public double powOfTwo(double minusCoordinate){
        return Math.pow(minusCoordinate, SQUARE_EXPONENT);
    }

    public double plusAndSquareRoot(double xDistance, double yDistance){
        return Math.sqrt(xDistance + yDistance);
    }



}
