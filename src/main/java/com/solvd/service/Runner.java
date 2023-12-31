package com.solvd.service;

import com.solvd.constant.BuildingType;
import com.solvd.entity.Profit;
import lombok.experimental.UtilityClass;

import static com.solvd.service.CustomScanner.scanUserInput;
import static com.solvd.service.DynamicContext.getOrder;
import static com.solvd.service.InputParser.parseToBoolean;
import static com.solvd.service.InputParser.parseToInt;
import static com.solvd.service.Printer.printBuildFasterMessage;
import static com.solvd.service.Printer.printBuildingChoiceMessage;
import static com.solvd.service.Printer.printEntity;
import static com.solvd.service.Printer.printInteriorDecorationMessage;

@UtilityClass
public class Runner {

    public static void main(String[] args) {
        printBuildingChoiceMessage();

        String input = scanUserInput();
        int selectedBuildingOption = parseToInt(input);
        getOrder().setBuildingType(BuildingType.values()[--selectedBuildingOption]);

        printBuildFasterMessage(getOrder().getBuildingType());
        input = scanUserInput();
        boolean selectedBuildFasterOption = parseToBoolean(input);
        getOrder().setBuildFaster(selectedBuildFasterOption);

        printInteriorDecorationMessage();
        input = scanUserInput();
        boolean selectedDecorationOption = parseToBoolean(input);
        getOrder().setDecorateInterior(selectedDecorationOption);

        printEntity(getOrder());

        Profit profit = new Profit(getOrder());

        printEntity(profit);
    }
}
