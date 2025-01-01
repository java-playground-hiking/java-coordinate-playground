package model;

import java.util.Objects;

public class Points {

    private final Point point1;
    private final Point point2;

    public Points(Point point1, Point point2){
        this.point1 = point1;
        this.point2 = point2;
    }

    public double minusX(){
        return point1.minusX(point2);
    }

    public double minusY(){
        return point1.minusY(point2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return Objects.equals(point1, points.point1) && Objects.equals(point2, points.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }

    public void drawPoints(int yValue, StringBuilder sb){
        point1.drawPointIfMatchY(yValue, sb);

        if (point1.isEqualY(point2)){
            point2.drawPointIfMatchY(yValue, sb, point1);
            return;
        }

        point2.drawPointIfMatchY(yValue, sb);

    }
}
