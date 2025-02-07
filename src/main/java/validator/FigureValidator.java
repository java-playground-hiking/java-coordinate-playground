package validator;

import enumclass.FigureType;
import messages.ErrorMessages;
import model.Figure;
import model.FigureFactory;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FigureValidator {
    private static final int MAX_COORDINATE = 24;
    private static final int MIN_COORDINATE = 0;


    public static Figure validate(String input){
        FigureType type = validatePattern(input);
        return FigureFactory.createFigure(type, input);

    }

    public static FigureType validatePattern(String input){
        for(FigureType type : FigureType.values()){
            if(Pattern.matches(generatePattern(type.getPointNum()), input)){
                return type;
            }
        }

        throw new IllegalArgumentException(ErrorMessages.INVALID_PATTERN);
    }

    public static String generatePattern(int pointNum){
        String pattern = "\\(\\d{1,2},\\d{1,2}\\)";

        return IntStream.range(0, pointNum)
                .mapToObj(i -> pattern)
                .collect(Collectors.joining("-"));
    }


    public static void validateRange(int x, int y){
        if (!isCorrectRange(x) || !isCorrectRange(y)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_RANGE);
        }
    }

    public static boolean isCorrectRange(int value){
        return value <= MAX_COORDINATE && value >= MIN_COORDINATE;
    }


    public static void validateRectangle(List<Double> linesLength){
        if (!isRectangle(linesLength)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_RECTANGLE);
        }
    }

    public static boolean isRectangle(List<Double> linesLength){
        return linesLength.get(0).equals(linesLength.get(1))
                && linesLength.get(2).equals(linesLength.get(3))
                && linesLength.get(4).equals(linesLength.get(5))
                && !linesLength.get(0).equals(linesLength.get(2));
    }

}
