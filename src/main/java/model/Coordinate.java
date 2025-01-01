package model;


import java.util.Objects;

public class Coordinate {
    private static final double MAX_COORDINATION = 24.0;
    private static final double MIN_COORDINATION = 0.0;
    private static final int GRAPH_SPACE = 3;

    private final double coordination;

    public Coordinate(double coordination){
        this.coordination = coordination;
    }

    public boolean isCorrectRange() {
        return coordination <= MAX_COORDINATION && coordination >= MIN_COORDINATION;
    }

    public boolean equals(double e){
        return coordination == e;
    }

    public int getGraphPosition(){
        return (int) (coordination * GRAPH_SPACE);
    }

    public int getGraphPositionDifference(Coordinate other){
        return (int) minus(other) * GRAPH_SPACE;
    }

    public double minus(Coordinate other) {
        return this.coordination - other.coordination;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(coordination, that.coordination) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordination);
    }

}

