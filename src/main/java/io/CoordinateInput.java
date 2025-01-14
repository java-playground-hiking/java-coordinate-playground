// File: input/CoordinateInput.java
package io;

import model.Point;
import util.InputScanner;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateInput {

    private static final String COORDINATE_PATTERN = "\\((\\d+),(\\d+)\\)"; // 좌표 형식에 대한 정규식.

    // 사용자 입력을 통해 좌표를 얻음 (단일 책임 원칙: 입력 처리만 수행).
    public Point[] getCoordinates() {
        Scanner scanner = InputScanner.getInstance(); // Scanner 유틸리티 사용.
        Pattern pattern = Pattern.compile(COORDINATE_PATTERN);

        while (true) {
            System.out.println("좌표를 (x1,y1)-(x2,y2) 형식으로 입력하세요:");
            String input = scanner.nextLine(); // 사용자 입력 읽기.
            String[] parts = input.split("-"); // 입력을 두 부분으로 나눔.

            if (parts.length == 2) { // 두 점 입력 여부 확인.
                Point[] points = new Point[2];
                try {
                    points[0] = parsePoint(parts[0], pattern); // 첫 번째 점 파싱.
                    points[1] = parsePoint(parts[1], pattern); // 두 번째 점 파싱.
                    return points; // 파싱된 점 반환.
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage()); // 에러 메시지 출력.
                }
            } else {
                System.out.println("잘못된 형식입니다. (x1,y1)-(x2,y2) 형식으로 입력하세요.");
            }
        }
    }

    // 단일 점을 문자열에서 파싱하는 메서드 (단일 책임 원칙: 파싱만 처리).
    private Point parsePoint(String part, Pattern pattern) {
        Matcher matcher = pattern.matcher(part.trim());
        if (matcher.matches()) {
            int x = Integer.parseInt(matcher.group(1)); // X 좌표 추출.
            int y = Integer.parseInt(matcher.group(2)); // Y 좌표 추출.
            return new Point(x, y); // 새 Point 객체 반환.
        } else {
            throw new IllegalArgumentException("잘못된 좌표 형식: " + part);
        }
    }
}

