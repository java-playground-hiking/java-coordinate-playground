package util;

import messages.ErrorMessages;

public class StringUtil {

    public static double parseDouble(String numStr){
        try{
            return Double.parseDouble(numStr);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_INPUT);
        }
    }
}
