package model;

import java.util.List;

public class Triangle extends Figure{
    private static final int SQUARE_EXPONENT = 2;

    private List<Double> linesLength;

    public Triangle(Points points) {
        super(points);
        this.linesLength = calculateAllLength();
    }

    @Override
    public double calculateResult() {
        double len1 = linesLength.get(0);
        double len2 = linesLength.get(1);
        double len3 = linesLength.get(2);

        double s = (len1 + len2 + len3) / SQUARE_EXPONENT;
        double area = Math.sqrt(s * (s - len1) * (s - len2) * (s - len3));
        return Math.round(area * 100.0) / 100.0;
    }

    @Override
    public String printResult(double result) {
        return "삼각형의 넓이는 " + result;
    }
}
