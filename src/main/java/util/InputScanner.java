package util;

import java.util.Scanner;

public class InputScanner {

    private static final Scanner INSTANCE = new Scanner(System.in); // Scanner의 단일 인스턴스.

    private InputScanner() {
        // 객체 생성을 방지.
    }

    // 공유 Scanner 인스턴스를 반환 (단일 책임 원칙: Scanner 관리만 수행).
    public static Scanner getInstance() {
        return INSTANCE;
    }
}
