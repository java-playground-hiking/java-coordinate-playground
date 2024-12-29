package coordinate.io;

import coordinate.messages.SystemMessage;
import java.util.Scanner;

public class ConsoleInputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public String inputFromUser() {
        System.out.println(SystemMessage.inputFigureSize);
        return scanner.nextLine();
    }

}
