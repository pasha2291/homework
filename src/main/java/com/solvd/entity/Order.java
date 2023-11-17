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
        int buildingTimeWeeks = buildingType.getBasicWeeksToBuild();
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
            totalPrice += (totalPrice * getBuildFasterCoefficients().get(0));
        }
        if(isDecorateInterior) {
            totalPrice += (totalPrice * getDecorateInteriorCoefficients().get(0));
        }
        return Math.ceil(totalPrice);
    }

    @Override
    public void printEntity() {
        logInfo(this.entityToString());
    }

    @Override
    public final String entityToString() {
        return "ИТОГО ЗАКАЗ: \n" + buildingType.toString() + "С отделкой: " + isDecorateInterior + "\n"
                + "Строим в две смены: " + isBuildFaster  + "\n"
                + "Итого построим за: " + calculateOrderTotalBuildingTime() + " недель.\n"
                + "Итоговая стоимость: " + calculateTotalPrice() + " $\n";
    }
}
