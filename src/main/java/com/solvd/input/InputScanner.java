package com.solvd.input;

import lombok.experimental.UtilityClass;

import java.util.Scanner;

import static com.solvd.input.InputValidator.isInputValid;
import static com.solvd.service.CustomLogger.logInfo;

@UtilityClass
public class InputScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static String scanUserInput(String regex) {
        String input = scanner.nextLine();
        while (!isInputValid(input, regex)) {
            logInfo("Wrong input, please check your input and try again!");
            input = scanner.nextLine();
        }
        return input;
    }
}
