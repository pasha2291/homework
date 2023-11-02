package com.solvd.service;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class InputValidator {
    private static final String validInputRegex = "[1-4]";
    private static final Pattern pattern = Pattern.compile(validInputRegex);

    public static boolean isInputValid(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
