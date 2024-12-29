package coordinate.plot;

import coordinate.point.Point;
import coordinate.point.PointList;
import coordinate.utils.StringUtils;
import java.util.List;
import java.util.stream.Collectors;

public class LinePlot {

    private final PointList figureSize;

    private LinePlot(PointList figureSize) {
        // [Point(x, y), Point(x, y)]
        this.figureSize = figureSize;
    }

    public static LinePlot from(String figureSize) {
        List<String> splitedByHyphen = StringUtils.splitByHyphen(figureSize);

        PointList figureSizes = PointList.from(splitedByHyphen.stream()
                .map(StringUtils::extractFromStringByRegex)
                .map(LinePlot::linePointNumberListToPointObject)
                .collect(Collectors.toList()));

        return new LinePlot(figureSizes);
    }

    /**
     * 제곱근((A.x - B.x)^제곱 + (A.y - B.y)^제곱)
     */
    public double distanceBetweenPoints() {
        Point firstPoint = figureSize.getPoints().get(0);
        Point secondPoint = figureSize.getPoints().get(1);

        return Math.sqrt((calculateByX(firstPoint, secondPoint) + calculateByY(firstPoint, secondPoint)));
    }

    public PointList getFigureSize() {
        return figureSize;
    }

    private static Point linePointNumberListToPointObject(List<Integer> pointNumberList) {
        int x = pointNumberList.get(0);
        int y = pointNumberList.get(1);
        return Point.of(x, y);
    }

    private double calculateByX(Point firstPoint, Point secondPoint) {
        int firstPointX = firstPoint.getX();
        int secondPointX = secondPoint.getX();
        return Math.pow(firstPointX - secondPointX, 2);
    }

    private double calculateByY(Point firstPoint, Point secondPoint) {
        int firstPointY = firstPoint.getY();
        int secondPointY = secondPoint.getY();

        return Math.pow(firstPointY - secondPointY, 2);
    }

}
