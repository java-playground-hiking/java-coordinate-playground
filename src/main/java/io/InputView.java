package io;

import java.util.Scanner;

public class InputView {
    public static String getInput() {
        System.out.println("좌표를 입력하세요.");
        System.out.println("직사각형을 만들기 위해 점 4개를 입력해야 합니다.");
        System.out.println("점 순서는 다음과 같아야 합니다:");
        System.out.println("1. 왼쪽 위 (Top-Left): (x1, y1)");
        System.out.println("2. 오른쪽 위 (Top-Right): (x2, y1)");
        System.out.println("3. 오른쪽 아래 (Bottom-Right): (x2, y2)");
        System.out.println("4. 왼쪽 아래 (Bottom-Left): (x1, y2)");
        System.out.println("예시: (10,10)-(20,10)-(20,20)-(10,20)");
        System.out.print("입력: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
