package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Figure {
    private static final int SQUARE_EXPONENT = 2;

    protected Points points;

    public Figure(Points points){
        this.points = points;
    }

    public abstract double calculateResult();
    public abstract String printResult(double result);


    public List<Double> calculateAllLength(){
        List<Double> lineLengths = new ArrayList<>();

        // TODO
        for(int i=0; i<points.size(); i++){
            for(int j=i+1; j<points.size(); j++){
                double distance = calculateDistance(points.getPoint(i), points.getPoint(j));
                lineLengths.add(distance);

            }
        }

        Collections.sort(lineLengths);

        return lineLengths;
    }

    public double calculateDistance(Point point1, Point point2){
        double xDistance = Math.pow((point1.minusX(point2)), SQUARE_EXPONENT);
        double yDistance = Math.pow((point1.minusY(point2)), SQUARE_EXPONENT);

        return Math.sqrt(xDistance + yDistance);
    }


    public void draw(StringBuilder[] graph) {
        for(int i=0; i<points.size(); i++){
            points.getPoint(i).drawPoint(graph);
        }
    }
}
