package coordinate.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import coordinate.exception.CoordinateException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    @DisplayName("문자열을 '-'을 기준으로 분리한다")
    void testSplitByHyphen() {
        // Given
        String string = "10-11";

        // When
        List<String> strings = StringUtils.splitByHyphen(string);

        // Then
        assertThat(strings).contains("10", "11");
        assertThat(strings.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("'-'이 포함 되지 않은 문자열을 분리 시킬 때 예외를 반환한다")
    void testSplitToNotContainsHyphenString() {
        // Given
        String string = "10, 11";

        assertThatThrownBy(() -> {
            // When
            StringUtils.splitByHyphen(string);
        })
                // Then
                .hasMessage("두 점의 좌표를 구분을 위해 '-' 필수로 입력 해야 합니다.")
                .isInstanceOf(CoordinateException.class);
    }

    @Test
    @DisplayName("좌표 형식에 맞는 문자열을 추출 하여 숫자로 변환한다")
    void testExtractFromCoordinateString() {
        // Given
        String coordinateString = "(10,11)";

        // When
        List<Integer> integers = StringUtils.extractFromStringToIntegerByRegex(coordinateString);

        // Then
        assertThat(integers).contains(10, 11);
        assertThat(integers.size()).isEqualTo(2);
    }
}
