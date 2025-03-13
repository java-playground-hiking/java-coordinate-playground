package io;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.coordinate.Coordinate;
import model.coordinate.Coordinates;

/*
- 나중에 확장성을 고려했을 때 어떤 데이터를 읽어서 처리할지 결정하기 쉽도록 `CoordinateReader` 인터페이스를 구현하면 좋을 것 같아요.
 */
public class CoordinateStringReader {

    public static final String COORDINATE_INPUT_FORMAT = "\\((\\d+),(\\d+)\\)";
    public static final String SPLIT_SEPARATOR = "-";
    private final String rawCoordinateString;

    private CoordinateStringReader(String rawCoordinateString) {

        if (rawCoordinateString.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.rawCoordinateString = rawCoordinateString;

    }

    public static CoordinateStringReader from(String rawCoordinateString) {
        return new CoordinateStringReader(rawCoordinateString);
    }

    public Coordinates getCoordinates() {

        List<String> stringCoordinates = splitByHyphen();

        return Coordinates.from(
                stringCoordinates.stream()
                        .map(this::getMatcherByInputFormat)
                        .filter(Matcher::matches)
                        .map(this::parseCoordinates)
                        .collect(Collectors.toList()
                        )
        );
    }

    private Coordinate parseCoordinates(Matcher numericMatcher) {
        List<Integer> parsedCoordinate = IntStream.range(1, numericMatcher.groupCount() + 1)
                .mapToObj(i -> Integer.parseInt(numericMatcher.group(i)))
                .collect(Collectors.toList());

        return Coordinate.of(parsedCoordinate.get(0), parsedCoordinate.get(1));
    }

    private List<String> splitByHyphen() {
        List<String> splited = List.of(rawCoordinateString.split(SPLIT_SEPARATOR));

        if (splited.size() == 1) {
            throw new IllegalArgumentException("두 개 이상의 좌표를 입력해야 합니다.");
        }

        return splited;
    }

    private Matcher getMatcherByInputFormat(String singleCoordinateString) {
        return Pattern.compile(COORDINATE_INPUT_FORMAT).matcher(singleCoordinateString);
    }
}


