package io;

import messages.ErrorMessages;
import model.Points;
import model.Rectangle;

import java.util.Scanner;

public class InputScanner {
    private final Scanner scanner;

    public InputScanner(){
        scanner = new Scanner(System.in);
    }

    public Points input(){
        System.out.println("좌표를 입력하세요.");
        return validateInput(scanner.nextLine());
    }

    public Points validateInput(String input){
        Points points;

        try{
            checkMatchPattern(input);
            points = Points.fromString(input);
            checkRectangleShapes(points);

        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return input();
        }

        return points;
    }

    public void checkMatchPattern(String input){
        if(!isMatchTwoPoints(input) && !isMatchFourPoints(input)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_PATTERN);
        }
    }

    public boolean isMatchTwoPoints(String input) {
        return input.matches("\\([0-9]{1,2},[0-9]{1,2}\\)-\\([0-9]{1,2},[0-9]{1,2}\\)");
    }


    public boolean isMatchFourPoints(String input) {
        return input.matches("\\([0-9]{1,2},[0-9]{1,2}\\)-\\([0-9]{1,2},[0-9]{1,2}\\)-\\([0-9]{1,2},[0-9]{1,2}\\)-\\([0-9]{1,2},[0-9]{1,2}\\)");
    }

    public void checkRectangleShapes(Points points){
        if (points.isFourPoints()){
            Rectangle rectangle = new Rectangle(points);
            rectangle.validateRectangle();
        }
    }

}
