package model;

public class Triangle extends Figure{
    public static final int TRIANGLE_POINT_SIZE = 3;
    private static final int SQUARE_EXPONENT = 2;

    public Triangle(Points points) {
        super(points);
    }

    public static Triangle from(Points points) {
        return new Triangle(points);
    }

    @Override
    public double calculateResult() {
        double len1 = linesLength.get(0);
        double len2 = linesLength.get(1);
        double len3 = linesLength.get(2);

        double s = (len1 + len2 + len3) / SQUARE_EXPONENT;
        double area = Math.sqrt(s * (s - len1) * (s - len2) * (s - len3));

        return roundToSecondDecimal(area);
    }

    @Override
    public String print(double result) {
        return "삼각형의 넓이는 " + result;
    }

}
