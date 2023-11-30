package com.solvd.service;

import com.solvd.constant.BuildingType;
import com.solvd.entity.Profit;
import com.solvd.exception.CustomException;
import lombok.experimental.UtilityClass;

import static com.solvd.constant.Message.ERROR;
import static com.solvd.constant.Message.RESTART_APPLICATION;
import static com.solvd.constant.Message.getMessage;
import static com.solvd.service.CustomLogger.logError;
import static com.solvd.service.CustomScanner.scanUserInput;
import static com.solvd.service.DynamicContext.getOrder;
import static com.solvd.service.Printer.printBuildFasterMessage;
import static com.solvd.service.Printer.printBuildingChoiceMessage;
import static com.solvd.service.Printer.printInteriorDecorationMessage;

@UtilityClass
public class Runner {

    public static void main(String[] args) {
        printBuildingChoiceMessage();

        try {
            String input = scanUserInput();
            int selectedBuildingOption = Integer.parseInt(input);
            getOrder().setBuildingType(BuildingType.values()[--selectedBuildingOption]);

            printBuildFasterMessage(getOrder());
            input = scanUserInput();
            boolean selectedBuildFasterOption = !input.equals("2");
            getOrder().setBuildFaster(selectedBuildFasterOption);

            printInteriorDecorationMessage();
            input = scanUserInput();
            boolean selectedDecorationOption = !input.equals("2");
            getOrder().setDecorateInterior(selectedDecorationOption);

            getOrder().printEntity();

            Profit profit = new Profit(getOrder());

            profit.printEntity();
        } catch (CustomException e) {
            logError(getMessage(ERROR));
            logError(e.getMessage());
            logError(getMessage(RESTART_APPLICATION));
            System.exit(1);
        }
    }
}
