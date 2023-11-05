package com.solvd.service;

import com.solvd.constant.BuildingType;
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

    public static void printListOfBuildingOptions() {
        BuildingType[] buildings = BuildingType.values();
        Arrays.stream(buildings).forEachOrdered(
                buildingType -> System.out.println(buildingType.toString())
        );
    }

    public static void printBuildingChoiceMessage() {
        System.out.println(SAY_HELLO);
        System.out.println();
        System.out.println(BUILD_OPTIONS);
        printListOfBuildingOptions();
        System.out.println(INPUT_VARIANT);
    }

    public static void printBuildFasterMessage(BuildingType buildingType) {
        System.out.println(String.format(BUILD_FASTER, buildingType.getBasicWeeksToBuild()));
        printTwoOptionMessage();
    }

    public static void printInteriorDecorationMessage() {
        System.out.println(DECORATE_INTERIOR);
        printTwoOptionMessage();
    }

    public static void printEntity(SolvdEntity entity) {
        System.out.println(entity.entityToString());
        System.out.println();
    }

    private static void printTwoOptionMessage() {
        System.out.println(OPTION_YES);
        System.out.println(OPTION_NO);
        System.out.println();
        System.out.println(INPUT_VARIANT);
    }
}
