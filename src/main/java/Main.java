import entity.Shape;
import entity.ShapeFactory;
import io.InputView;
import io.ResultView;

public class Main {
    public static void main(String[] args) {
        try {
            String input = InputView.getInput();
            Shape shape = ShapeFactory.createShape(input);
            double area = shape.calculateArea();
            ResultView.printArea(area);
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("예기치 못한 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
