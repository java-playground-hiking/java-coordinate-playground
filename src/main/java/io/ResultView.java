package io;

import model.Figure;
import model.Graph;

public class ResultView {
    private Figure figure;
    private Graph graph;
    private double result;

    public ResultView(Figure figure, double result){
        this.figure = figure;
        this.graph = Graph.from(figure);
        this.result = result;
    }

    public void print(){
        StringBuilder[] graphDrawing  = graph.draw();

        for (StringBuilder drawing : graphDrawing){
            System.out.println(drawing.toString());
        }

        System.out.println(figure.printResult(result));
    }

}
