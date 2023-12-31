package com.solvd.service;

import com.solvd.constant.BuildingType;
import com.solvd.entity.Order;
import com.solvd.entity.SolvdEntity;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

import static com.solvd.constant.Message.BUILD_FASTER;
import static com.solvd.constant.Message.BUILD_OPTIONS;
import static com.solvd.constant.Message.DECORATE_INTERIOR;
import static com.solvd.constant.Message.INPUT_VARIANT;
import static com.solvd.constant.Message.OPTION_NO;
import static com.solvd.constant.Message.OPTION_YES;
import static com.solvd.constant.Message.SAY_HELLO;

@UtilityClass
public class Printer {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printListOfBuildingOptions() {
        BuildingType[] buildings = BuildingType.values();
        Arrays.stream(buildings).forEachOrdered(
                buildingType -> System.out.println(buildingType.toString())
        );
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printBuildingChoiceMessage() {
        printMessage(SAY_HELLO);
        printBlankLine();
        printMessage(BUILD_OPTIONS);
        printListOfBuildingOptions();
        printMessage(INPUT_VARIANT);
    }

    public static void printBuildFasterMessage(BuildingType buildingType) {
        printMessage(String.format(BUILD_FASTER, buildingType.getBasicWeeksToBuild()));
        printTwoOptionMessage();
    }

    public static void printInteriorDecorationMessage() {
        printMessage(DECORATE_INTERIOR);
        printTwoOptionMessage();
    }

    public static void printEntity(SolvdEntity entity) {
        System.out.println(entity.entityToString());
    }

    private static void printTwoOptionMessage() {
        printMessage(OPTION_YES);
        printMessage(OPTION_NO);
        printBlankLine();
        printMessage(INPUT_VARIANT);
    }
}
