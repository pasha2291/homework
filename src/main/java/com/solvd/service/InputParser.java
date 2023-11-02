package com.solvd.service;

import lombok.experimental.UtilityClass;

@UtilityClass
public class InputParser {

    public static int parseToInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean parseToBoolean(String input) {
        return !input.equals("2");
    }
}
