package coordinate.messages;

public class ErrorMessage {

    public static final String invalidPoint = "좌표는 최소 0부터 최대 24까지 입력 할 수 있습니다.";
    public static final String hyphenMustHave = "두 점의 좌표를 구분을 위해 '-' 필수로 입력 해야 합니다.";
    public static final String numberFormatFailed = "좌표는 숫자만 입력해야 합니다.";
    public static final String regexNotMatched = "좌표는 '(x, y) 형식으로 입력하며 숫자만 입력 해야 합니다.";

}
