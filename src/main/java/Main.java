import entity.Shape;
import entity.ShapeFactory;
import io.InputView;
import io.ResultView;

/**
 * 프로그램의 시작점.
 * 입력 -> 처리 -> 결과 출력의 흐름을 담당합니다.
 */
public class Main {
    public static void main(String[] args) {
        // 사용자로부터 좌표 입력받기
        String input = InputView.getInput();

        // 입력된 좌표를 바탕으로 도형 객체 생성
        Shape shape = ShapeFactory.createShape(input);

        // 도형의 넓이 계산
        int area = shape.calculateArea();

        // 결과 출력
        ResultView.printArea(area);
    }
}
