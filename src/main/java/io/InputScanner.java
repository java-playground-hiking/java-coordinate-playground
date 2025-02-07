package io;

import model.Figure;
import validator.FigureValidator;

import java.util.Scanner;

public class InputScanner {
    private final Scanner scanner;

    public InputScanner(){
        scanner = new Scanner(System.in);
    }

    public Figure input(){
        System.out.println("좌표를 입력하세요.");
        return validateInput(scanner.nextLine());
    }

    public Figure validateInput(String input){
        try{
            return FigureValidator.validate(input);
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return input();
        }
    }


}
