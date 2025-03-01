package utils;

import exception.CoordinateException;
import exception.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CoordinateUtils {

    public static List<Integer> splitNumbers(String value) {
        return Pattern.compile("\\d+")
                .matcher(value)
                .results()
                .map(MatchResult::group)
                .map(CoordinateUtils::convertStringToInteger)
                .toList();
    }

    public static int convertStringToInteger(String value) {
        try{
            return Integer.parseInt(value);
        } catch (Exception e){
            throw new CoordinateException(ErrorMessages.INVALID_INPUT_NUMBER);
        }
    }
}
