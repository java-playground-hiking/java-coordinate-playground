package model;

public class Line {
    public static final int SQUARE_EXPONENT = 2;

    private Points points;

    public Line(Points points){
        this.points = points;
    }

    public static Line of(Point point1, Point point2) {
        return new Line(Points.from(point1, point2));
    }

    public double calculateLength(){
        double xDistance = powOfTwo(minusX());
        double yDistance = powOfTwo(minusY());

        return Math.sqrt(xDistance + yDistance);
    }

    public double minusX(){
        return points.getPoint(0).minusX(points.getPoint(1));
    }
    public double minusY(){
        return points.getPoint(0).minusY(points.getPoint(1));
    }

    public double powOfTwo(double minusCoordinate){
        return Math.pow(minusCoordinate, SQUARE_EXPONENT);
    }

}
