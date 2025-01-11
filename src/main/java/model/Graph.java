package model;

public class Graph {
    private final static int TOTAL_X_SIZE = 48;
    private final static int TOTAL_Y_SIZE = 26;
    private final static int X_LINE = 24;
    private final static int X_NUMBER_LINE = 25;
    private final static int MAX_NUMBER = 24;

    private Points points;
    private StringBuilder[] graph;

    public Graph(Points points){
        this.points = points;
        initGraph();
    }

    public void initGraph(){
        graph = new StringBuilder[TOTAL_Y_SIZE];

        for (int i=0; i<=X_LINE; i++){
            graph[i] = new StringBuilder("  ".repeat(TOTAL_X_SIZE));
        }
    }

    public static Graph from(Points points){
        return new Graph(points);
    }

    public StringBuilder[] draw(){
        drawY();
        drawX();
        points.drawPoints(graph);

        return graph;
    }


    public void drawY(){
        int yNum = MAX_NUMBER;

        for(int i=0; i<MAX_NUMBER; i++){
            drawYLine(i, yNum);
            yNum -= 1;
        }
    }

    public void drawYLine(int i, int yNum){
        String str = "  |";

        if (i % 2 == 0){
            str = String.format("%2d|", yNum);
        }

        graph[i].replace(0, 3, str);
    }


    public void drawX(){
        drawXLine();
        drawXNumber();
    }

    public void drawXLine(){
        graph[X_LINE].replace(0, TOTAL_X_SIZE, "  +" + "―".repeat(TOTAL_X_SIZE));
    }

    public void drawXNumber(){
        graph[X_NUMBER_LINE] = new StringBuilder();

        for(int i=0; i<=MAX_NUMBER; i+=2){
            graph[X_NUMBER_LINE].append(String.format("%-6d", i));
        }
    }


}
