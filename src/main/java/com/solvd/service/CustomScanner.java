package com.solvd.service;

import com.solvd.exception.InvalidInputException;
import lombok.experimental.UtilityClass;

import java.util.Scanner;

import static com.solvd.service.InputValidator.isInputValid;

@UtilityClass
public class CustomScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static String scanUserInput() throws InvalidInputException {
        String input = scanner.nextLine();
        if(!isInputValid(input)) {
            throw new InvalidInputException("Invalid user input: " + input);
        }
        return input;
    }
}
