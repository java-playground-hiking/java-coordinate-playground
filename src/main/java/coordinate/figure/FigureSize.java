package coordinate.figure;

import coordinate.point.Coordinate;
import coordinate.point.Points;
import coordinate.utils.StringUtils;
import java.util.List;
import java.util.stream.Collectors;

public class FigureSize {

    private final List<Coordinate> figureSizes;

    private FigureSize(List<Coordinate> figureSizes) {
        this.figureSizes = figureSizes;
    }

    public static FigureSize from(String userInputFigureSize) {
        List<String> splitedByHyphen = StringUtils.splitByHyphen(userInputFigureSize);

        List<Coordinate> figureSizes = splitedByHyphen.stream()
                .map(Coordinate::from)
                .collect(Collectors.toList());

        return new FigureSize(figureSizes);
    }

    public Points toPoints() {
        return Points.from(figureSizes.stream()
                .map(Coordinate::toPoint)
                .collect(Collectors.toList()));
    }

}
