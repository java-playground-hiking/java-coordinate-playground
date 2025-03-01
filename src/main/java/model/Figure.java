package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Figure {
    private static final int SQUARE_EXPONENT = 2;
    private static final double ROUNDING_FACTOR = 100.0;

    protected Points points;
    protected List<Double> linesLength;

    public Figure(Points points){
        this.points = points;
        this.linesLength = calculateAllDistance();
    }

    public abstract double calculateResult();
    public abstract String print(double result);

    public List<Double> calculateAllDistance(){
        List<Double> distances = new ArrayList<>();

        for(int i=0; i<points.size(); i++){
            for(int j=i+1; j<points.size(); j++){
                distances.add(calculateDistance(points.getPoint(i), points.getPoint(j)));
            }
        }

        Collections.sort(distances);
        return distances;
    }

    public double calculateDistance(Point point1, Point point2){
        double xDistance = Math.pow((point1.minusX(point2)), SQUARE_EXPONENT);
        double yDistance = Math.pow((point1.minusY(point2)), SQUARE_EXPONENT);

        return Math.sqrt(xDistance + yDistance);
    }

    public double roundToSecondDecimal(double result){
        return Math.round(result * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }

}
