import io.InputScanner;
import io.ResultView;
import model.Figure;

public class CoordinateMain {
    public static void main(String[] args) {
        InputScanner scanner = new InputScanner();
        Figure figure = scanner.input();

        double result = figure.calculateResult();

        ResultView view = new ResultView(figure, result);
        view.print();
    }
}
