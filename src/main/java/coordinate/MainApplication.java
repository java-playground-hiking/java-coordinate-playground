package coordinate;

import coordinate.figure.Figure;
import coordinate.figure.FigureFactory;
import coordinate.figure.FigureSize;
import coordinate.graph.Graph;
import coordinate.io.ConsoleInputHandler;
import coordinate.io.ConsoleOutputHandler;

public class MainApplication {
    private static final ConsoleInputHandler inputHandler = new ConsoleInputHandler();
    private static final ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();

    public static void main(String[] args) {
        FigureSize figureSize = inputHandler.getFigureSize();
        Figure figure = FigureFactory.create(figureSize);
        Graph graph = Graph.from(figure);
        outputHandler.printGraph(graph);
    }
}