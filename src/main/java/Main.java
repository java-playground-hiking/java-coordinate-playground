import io.InputView;
import model.Figure;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Figure figure = inputView.input();

        double result = figure.calculateResult();
        System.out.println(figure.print(result));
    }
}
