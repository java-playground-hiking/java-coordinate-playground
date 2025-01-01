package io;

import model.Points;

public class ResultView {
    private static final int MAX_X = 24;
    private static final int MAX_Y = 24;
    private static final int MAX_X_LINE = 48;

    private Points points;
    private double result;

    private StringBuilder sb;

    public ResultView(Points points, double result){
        this.points = points;
        this.result = result;
        this.sb = new StringBuilder();
    }

    public void print(){
        System.out.println(drawGraph());
        System.out.println("두 점 사이 거리는 " + result);
    }

    public String drawGraph(){
        drawY();
        drawX();

        return sb.toString();
    }

    public void drawY(){
        for(int i=MAX_Y; i>0; i--){
            drawYLine(i);
            points.drawPoints(i, sb);
            sb.append("\n");
        }
    }

    public void drawYLine(int i){
        String str = "  |";

        if (i % 2 == 0){
            str = String.format("%2d|", i);
        }

        sb.append(str);
    }


    public void drawX(){
        drawXLine();

        sb.append("   ");

        for(int i=0; i<=MAX_X; i+=2){
            sb.append(String.format("%-6d", i));
        }
    }

    public void drawXLine(){
        sb.append("  +")
            .append("―".repeat(MAX_X_LINE))
            .append("\n");
    }


}
