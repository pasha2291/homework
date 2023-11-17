package com.solvd.service;

import com.solvd.constant.BuildingType;
import com.solvd.entity.Order;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

import static com.solvd.constant.Message.BUILD_FASTER;
import static com.solvd.constant.Message.BUILD_OPTIONS;
import static com.solvd.constant.Message.DECORATE_INTERIOR;
import static com.solvd.constant.Message.INPUT_VARIANT;
import static com.solvd.constant.Message.OPTION_NO;
import static com.solvd.constant.Message.OPTION_YES;
import static com.solvd.constant.Message.SAY_HELLO;
import static com.solvd.constant.Message.getMessage;
import static com.solvd.service.CustomLogger.logInfo;

@UtilityClass
public class Printer {

    public static void printListOfBuildingOptions() {
        BuildingType[] buildings = BuildingType.values();
        Arrays.stream(buildings).forEachOrdered(
                buildingType -> System.out.println(buildingType.toString())
        );
    }

    public static void printBuildingChoiceMessage() {
        logInfo(getMessage(SAY_HELLO));
        logInfo(getMessage(BUILD_OPTIONS));
        printListOfBuildingOptions();
        logInfo(getMessage(INPUT_VARIANT));
    }

    public static void printBuildFasterMessage(BuildingType buildingType) {
        logInfo(String.format(getMessage(BUILD_FASTER), buildingType.getBasicWeeksToBuild()));
        printTwoOptionMessage();
    }

    public static void printBuildFasterMessage(Order order) {
        logInfo(String.format(getMessage(BUILD_FASTER), order.getBuildingType().getBasicWeeksToBuild()));
        printTwoOptionMessage();
    }

    public static void printBuildFasterMessage(String message) {
        logInfo(message);
        printTwoOptionMessage();
    }

    public static void printInteriorDecorationMessage() {
        logInfo(getMessage(DECORATE_INTERIOR));
        printTwoOptionMessage();
    }

    private static void printTwoOptionMessage() {
        logInfo(getMessage(OPTION_YES));
        logInfo(getMessage(OPTION_NO));
        logInfo(getMessage(INPUT_VARIANT));
    }
}
