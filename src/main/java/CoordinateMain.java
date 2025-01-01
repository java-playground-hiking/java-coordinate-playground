import io.ResultView;
import model.Calculator;
import model.Points;
import io.CoordinateScanner;

public class CoordinateMain {
    public static void main(String[] args) {
        CoordinateScanner scanner = new CoordinateScanner();
        Points points = scanner.input();

        Calculator calculator = new Calculator(points);
        double result = calculator.distance();

        ResultView resultView = new ResultView(points, result);
        resultView.print();
    }
}
