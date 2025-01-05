package coordinate.io;

import coordinate.exception.CoordinateException;
import coordinate.figure.FigureSize;
import coordinate.messages.SystemMessage;
import java.util.Scanner;

public class ConsoleInputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public FigureSize getFigureSize() {
        try {
            return FigureSize.from(inputFromUser());
        } catch (CoordinateException e) {
            System.out.println(e.getMessage());
            return getFigureSize();
        }
    }

    private String inputFromUser() {
        System.out.println(SystemMessage.inputFigureSize);
        return scanner.nextLine();
    }

}
