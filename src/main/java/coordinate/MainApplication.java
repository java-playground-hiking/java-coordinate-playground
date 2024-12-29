package coordinate;

import coordinate.graph.Graph;
import coordinate.io.ConsoleInputHandler;
import coordinate.io.ConsoleOutputHandler;
import coordinate.plot.LinePlot;

public class MainApplication {

    public static void main(String[] args) {
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();

        String figureSize = inputHandler.inputFromUser();

        LinePlot linePlot = LinePlot.from(figureSize);
        Graph graph = Graph.from(linePlot);
        outputHandler.printGraph(graph.draw());

    }
}
