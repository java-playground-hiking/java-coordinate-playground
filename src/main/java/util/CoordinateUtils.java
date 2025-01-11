package util;

import messages.ErrorMessages;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CoordinateUtils {

    public static Integer parseInteger(String str){
        try{
            return Integer.parseInt(str);
        } catch (IllegalArgumentException ex){
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER);
        }
    }

    public static List<Integer> splitStringToInteger(String str){
        return Pattern.compile("\\d+")
                .matcher(str)
                .results()
                .map(MatchResult::group)
                .map(CoordinateUtils::parseInteger)
                .toList();
    }
}
