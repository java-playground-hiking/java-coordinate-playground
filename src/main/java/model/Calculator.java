package model;

public class Calculator {

    private Points points;

    public Calculator(Points points){
        this.points = points;
    }

    public double calculate(){
        if (points.isTwoPoints()){
            Line line = new Line(points);
            return line.calculateLength();
        }

        Rectangle rectangle = new Rectangle(points);
        return rectangle.calculateArea();
    }



}
