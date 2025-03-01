package io;

import exception.CoordinateException;
import model.Figure;
import model.FigureFactory;
import utils.CoordinateUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Figure input(){
        System.out.println("좌표를 입력하세요");
        return getFigure();
    }

    private Figure getFigure() {
        try{
            String input = scanner.nextLine();
            List<Integer> numbers = CoordinateUtils.splitNumbers(input);
            return new FigureFactory().create(numbers);
        } catch (CoordinateException ex){
            System.out.println(ex.getMessage());
            return input();
        }
    }


}
