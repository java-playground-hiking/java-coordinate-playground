package coordinate.io;

import coordinate.graph.Graph;

public class ConsoleOutputHandler {

    public void printGraph(Graph graph) {
        System.out.println(graph.draw().toString());
    }
}
