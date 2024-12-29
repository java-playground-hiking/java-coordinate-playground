package coordinate.graph;

import coordinate.messages.SystemMessage;
import coordinate.plot.LinePlot;
import coordinate.point.PointList;
import java.util.stream.IntStream;

public class Graph {

    public static final int MAX_VALUE = 24;
    public static final int MIN_VALUE = 0;
    public static final int MAX_INT_RANGE = 25;
    public static final String PLUS_MARK = "+";
    private static final String PIPE = "|";
    private static final String DOUBLE_HYPHEN = "--";
    private static final String NEW_LINE = System.lineSeparator();
    public static final String POINT_MARK = "•";
    public static final String SPACE = " ";

    private final StringBuilder graphBuilder = new StringBuilder();
    private final LinePlot linePlot;

    private Graph(LinePlot linePlot) {
        this.linePlot = linePlot;
    }

    public static Graph from(LinePlot linePlot) {
        return new Graph(linePlot);
    }

    public StringBuilder draw() {
        verticalDrawAndPoint();
        horizontalDraw();
        distanceBetweenPointsResult();
        return graphBuilder;
    }

    private void distanceBetweenPointsResult() {
        graphBuilder.append(NEW_LINE);
        graphBuilder.append(SystemMessage.distancePoints);
        graphBuilder.append(linePlot.distanceBetweenPoints());
    }

    private void verticalDrawAndPoint() {
        for (int y = MAX_VALUE; y > MIN_VALUE; y--) {
            verticalDrawNumberWithPipe(y);
            drawPoint(y, linePlot.getFigureSize());
            graphBuilder.append(NEW_LINE);
        }
    }

    private void verticalDrawNumberWithPipe(int y) {
        if (isEvenNumber(y)) {
            graphBuilder.append(String.format("%3d|", y));
            return;
        }

        graphBuilder.append(String.format("%4s", PIPE));
    }

    private void drawPoint(int y, PointList points) {
        for (int x = 0; x < MAX_INT_RANGE; x++) {
            markAdd(x, y, points);
        }
    }

    private void markAdd(int x, int y, PointList points) {
        if (points.isMark(x, y)) {
            graphBuilder.append(String.format("%s", POINT_MARK));
            return;
        }

        graphBuilder.append(String.format("%2s", SPACE));
    }

    private void horizontalDraw() {
        horizontalLineDraw();
        horizontalNumberDraw();
    }

    private void horizontalNumberDraw() {
        IntStream.range(MIN_VALUE, MAX_INT_RANGE)
                .filter(this::isEvenNumber)
                .forEach(x -> graphBuilder.append(String.format("%4d", x)));
        graphBuilder.append(NEW_LINE);
    }

    private void horizontalLineDraw() {
        graphBuilder.append(String.format("%4s", PLUS_MARK));
        IntStream.range(MIN_VALUE, MAX_VALUE).forEach(i -> graphBuilder.append(String.format("%2s", DOUBLE_HYPHEN)));
        graphBuilder.append("\n");
    }

    private boolean isEvenNumber(int value) {
        return value % 2 == MIN_VALUE;
    }
}
