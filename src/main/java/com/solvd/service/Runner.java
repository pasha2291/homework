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

/*
1) Исправить замечания и предложение по логике и реализации проекта (комментарии будут добавлены 04.11 под вашими дз)
        2) Добавить в проект:
        - 5 интерфейсов к существующей иерархии. (Нужно использовать в проекте, не должны быть заготовкой).
        Если по логике программы вам не нужно 5, то нужно придумать/дописать логику.
        - Final класс, метод, переменную. (минимум по 1шт. , если есть возможность можно больше, нужно использовать их)
        - Static блок, метод, переменную. (минимум по 1шт. , если есть возможность можно больше, нужно использовать их)
        - 3 перегрузки метода
*/


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
