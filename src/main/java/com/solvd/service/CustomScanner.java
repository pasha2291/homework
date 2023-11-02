package com.solvd.service;

import lombok.experimental.UtilityClass;

import java.util.Scanner;

import static com.solvd.constant.Message.ERROR;
import static com.solvd.service.InputValidator.isInputValid;
import static com.solvd.service.Printer.printMessage;

@UtilityClass
public class CustomScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static String scanUserInput() {
        String input = scanInput();
        while (!isInputValid(input)) {
            printMessage(ERROR);
            input = scanInput();
        }
        return input;
    }

    private static String scanInput() {
      return scanner.nextLine();
    }
}
