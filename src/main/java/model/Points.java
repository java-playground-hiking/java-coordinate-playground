package model;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private List<Point> points;

    public Points(List<Point> points){
        this.points = points;
    }

    public static Points from(List<Integer> numbers){
        List<Point> points = new ArrayList<>();

        for(int i=0; i<numbers.size(); i+=2){
            Point point = Point.of(numbers.get(i), numbers.get(i+1));
            points.add(point);
        }

        return new Points(points);
    }

    public Point getPoint(int index){
        return points.get(index);
    }

    public int size(){
        return points.size();
    }


}
