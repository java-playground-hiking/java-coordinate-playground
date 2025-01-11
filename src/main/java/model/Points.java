package model;

import util.CoordinateUtils;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private List<Point> points;

    public Points(){
        this.points = new ArrayList<>();
    }

    public Points(Point point1, Point point2){
        this.points = new ArrayList<>(List.of(point1, point2));
    }

    public static Points from(Point point1, Point point2){
        return new Points(point1, point2);
    }

    public static Points fromString(String input){
        List<Integer> numbers = CoordinateUtils.splitStringToInteger(input);

        Points points = new Points();
        for(int i=0; i<numbers.size(); i+=2){
            points.addPoint(numbers.get(i), numbers.get(i+1));
        }

        return points;
    }


    public void addPoint(int x, int y){
        points.add(Point.of(x, y));
    }

    public boolean isTwoPoints() {
        return points.size() == 2;
    }

    public boolean isFourPoints() {
        return points.size() == 4;
    }

    public Point getPoint(int index){
        return points.get(index);
    }

    public int size(){
        return points.size();
    }

    public void drawPoints(StringBuilder[] graph) {
        for (Point point : points) {
            point.drawPoint(graph);
        }
    }


}
