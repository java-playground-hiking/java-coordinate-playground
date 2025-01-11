package model;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final Points points;
    private final List<Line> lines;

    public Lines(Points points){
        this.points = points;
        this.lines = createAllLines();
    }

    public List<Line> createAllLines(){
        List<Line> lineList = new ArrayList<>();

        for (int i=0; i<points.size(); i++){
            allLineForPoints(points, lineList, i);
        }

        return lineList;
    }

    public void allLineForPoints(Points points, List<Line> lineList, int i){
        for (int j=i+1; j<points.size(); j++){
            lineList.add(Line.of(points.getPoint(i), points.getPoint(j)));
        }
    }


    public List<Double> allSortedLinesLength(){
        return lines.stream()
                .map(Line::calculateLength)
                .sorted()
                .toList();
    }
}
