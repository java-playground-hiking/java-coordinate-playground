package io;

import messages.ErrorMessages;
import model.Point;
import model.Points;
import util.StringUtil;

import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CoordinateScanner {

    private final Scanner scanner;

    public CoordinateScanner(){
        scanner = new Scanner(System.in);
    }

    public Points input(){
        System.out.println("좌표를 입력하세요.");
        String input = scanner.nextLine();

        return validDots(input);

    }

    public Points validDots(String input){
        Points points;

        try{
            checkMatchFormat(input);
            points = parseNumber(input);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return input();
        }

        return points;
    }


    public void checkMatchFormat(String input){
        if(!isMatchFormat(input)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_FORMAT_INPUT);
        }
    }

    public boolean isMatchFormat(String input){
        return input.matches("\\([0-9]{1,2},[0-9]{1,2}\\)-\\([0-9]{1,2},[0-9]{1,2}\\)");
    }

    public Points parseNumber(String input){
        List<Double> numbers = Pattern.compile("\\d+")
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .map(StringUtil::parseDouble)
                .toList();

        Point point1 = Point.from(numbers.get(0), numbers.get(1));
        Point point2 = Point.from(numbers.get(2), numbers.get(3));

        return new Points(point1, point2);
    }




}
