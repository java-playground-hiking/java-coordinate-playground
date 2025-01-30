package coordinate.figure;

public class FigureFactory {

    public static Figure create(FigureSize figureSize) {
        return FigureType.create(figureSize);
    }
}
