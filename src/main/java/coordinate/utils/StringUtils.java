package coordinate.utils;

import coordinate.exception.CoordinateException;
import coordinate.messages.ErrorMessage;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtils {

    public static List<String> splitByHyphen(String string) {
        if (!string.contains("-")) {
            throw new CoordinateException(ErrorMessage.hyphenMustHave);
        }

        return List.of(string.split("-"));
    }

    public static List<Integer> extractFromStringToIntegerByRegex(String string) {
        String regex = "\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.matches()) {
            return IntStream.range(1, matcher.groupCount() + 1)
                    .mapToObj(i -> stringMatcherToInt(matcher, i))
                    .collect(Collectors.toList());
        }

        throw new CoordinateException(ErrorMessage.regexNotMatched);
    }

    private static int stringMatcherToInt(Matcher matcher, int groupIndex) {
        return Integer.parseInt(matcher.group(groupIndex));
    }

}
