package io;

import model.Graph;
import model.Points;

public class ResultView {

    private Points points;
    private Graph graph;
    private double result;

    public ResultView(Points points, double result){
        this.points = points;
        this.graph = Graph.from(points);
        this.result = result;
    }

    public void print(){
        StringBuilder[] graphDrawing  = graph.draw();

        for (StringBuilder drawing : graphDrawing){
            System.out.println(drawing.toString());
        }

        if (points.isTwoPoints()){
            System.out.println("두 점 사이 거리는 " + result);
        }

        System.out.println("사각형의 넓이는 " + result);
    }

}
