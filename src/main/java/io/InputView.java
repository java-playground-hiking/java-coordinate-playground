package io;

import java.util.Scanner;

public class InputView {
    public static String getInput() {
        System.out.println("좌표를 입력하세요.");
        System.out.println("직선: (x1,y1)-(x2,y2)");
        System.out.println("삼각형: (x1,y1)-(x2,y2)-(x3,y3)");
        System.out.print("입력: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
