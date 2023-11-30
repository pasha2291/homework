package com.solvd.entity;

import com.solvd.action.OrderAction;
import com.solvd.action.PrintAction;
import com.solvd.action.SolvdEntityAction;
import com.solvd.action.TotalPriceCalculatorAction;
import com.solvd.constant.BuildingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.solvd.constant.CoefficientType.getBuildFasterCoefficients;
import static com.solvd.constant.CoefficientType.getDecorateInteriorCoefficients;
import static com.solvd.lambda_function.Functions.ADD_NEW_LINE;
import static com.solvd.lambda_function.Functions.CAST_TO_INT;
import static com.solvd.lambda_function.Functions.MULTIPLY;
import static com.solvd.service.CustomLogger.logInfo;

@NoArgsConstructor
@Getter
@Setter
public final class Order implements SolvdEntityAction, TotalPriceCalculatorAction, PrintAction, OrderAction {
    private BuildingType buildingType;
    private boolean isBuildFaster;
    private boolean isDecorateInterior;

    @Override
    public int calculateOrderTotalBuildingTime() {
        int buildingTimeWeeks = CAST_TO_INT.applyAsInt(buildingType.getBasicWeeksToBuild());
        if(isBuildFaster) {
            buildingTimeWeeks -= (buildingTimeWeeks * getBuildFasterCoefficients().get(1));
        }
        if(isDecorateInterior()) {
            buildingTimeWeeks += (buildingTimeWeeks * getDecorateInteriorCoefficients().get(1));
        }
        return buildingTimeWeeks;
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = buildingType.getBasicPrice();
        if(isBuildFaster) {
            totalPrice += MULTIPLY.apply(totalPrice, getBuildFasterCoefficients().get(0));
        }
        if(isDecorateInterior) {
            totalPrice += MULTIPLY.apply(totalPrice, getDecorateInteriorCoefficients().get(0));
        }
        return Math.ceil(totalPrice);
    }

    @Override
    public void printEntity() {
        logInfo(this.entityToString());
    }

    @Override
    public final String entityToString() {
        return ADD_NEW_LINE.apply("ИТОГО ЗАКАЗ: ") + buildingType.toString() + "С отделкой: " + ADD_NEW_LINE.apply(Boolean.toString(isDecorateInterior))
                + "Строим в две смены: " + ADD_NEW_LINE.apply(Boolean.toString(isBuildFaster))
                + "Итого построим за: " + calculateOrderTotalBuildingTime() + ADD_NEW_LINE.apply(" недель.")
                + "Итоговая стоимость: " + calculateTotalPrice() + ADD_NEW_LINE.apply(" $");
    }
}
