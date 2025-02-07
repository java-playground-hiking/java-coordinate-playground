package enumclass;

import model.*;

public enum FigureType {
    LINE(2){
        @Override
        public Figure of(Points points) {
            return new Line(points);
        }
    },
    TRIANGLE(3){
        @Override
        public Figure of(Points points) {
            return new Triangle(points);
        }
    },
    RECTANGLE(4){
        @Override
        public Figure of(Points points) {
            return new Rectangle(points);
        }
    };

    private final int pointNum;
    public abstract Figure of(Points points);

    FigureType(int pointNum) {
        this.pointNum = pointNum;
    }

    public int getPointNum(){
        return pointNum;
    }


}
