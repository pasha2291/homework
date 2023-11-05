package com.solvd.service;

import lombok.experimental.UtilityClass;

import java.util.Scanner;

import static com.solvd.constant.Message.ERROR;
import static com.solvd.service.InputValidator.isInputValid;

@UtilityClass
public class CustomScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static String scanUserInput() {
        String input = scanner.nextLine();
        while (!isInputValid(input)) {
            System.out.println(ERROR);
            input = scanner.nextLine();
        }
        return input;
    }
}
