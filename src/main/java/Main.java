import io.CoordinateInput;
import model.Point;
import model.DistanceCalculator;
import io.CoordinateView;

public class Main {

    public static void main(String[] args) {
        // 입력
        CoordinateInput coordinateInput = new CoordinateInput();
        // 출력
        CoordinateView coordinateView = new CoordinateView();

        // 두 좌표 입력 받기
        Point[] points = coordinateInput.getCoordinates();
        // 입력 체크
        if (points.length == 2) {
            // 거리 계산
            double distance = DistanceCalculator.calculate(points[0], points[1]);
            coordinateView.printDistance(distance);
        }
    }
}
