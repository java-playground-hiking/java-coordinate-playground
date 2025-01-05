package coordinate.point;

import coordinate.utils.StringUtils;
import java.util.List;
import java.util.Objects;

public class Coordinate {

    private final List<Integer> coordinate;

    private Coordinate(List<Integer> coordinate) {
        this.coordinate = coordinate;
    }

    public static Coordinate from(String coordinateStringWithBracket) {
        return new Coordinate(StringUtils.extractFromStringToIntegerByRegex(coordinateStringWithBracket));
    }

    public Point toPoint() {
        return Point.of(coordinate.get(0), coordinate.get(1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return Objects.equals(coordinate, that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinate);
    }
}
