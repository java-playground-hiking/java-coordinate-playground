import io.InputScanner;
import io.ResultView;
import model.Calculator;
import model.Points;

public class CoordinateMain {
    public static void main(String[] args) {
        InputScanner scanner = new InputScanner();
        Points points = scanner.input();

        Calculator calculator = new Calculator(points);
        double result = calculator.calculate();

        ResultView resultView = new ResultView(points, result);
        resultView.print();

    }


}
