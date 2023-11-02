package com.solvd.entity;

import com.solvd.constant.BuildingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.solvd.constant.CoefficientType.BUILD_FASTER;
import static com.solvd.constant.CoefficientType.DECORATE_INTERIOR;

@NoArgsConstructor
@Getter
@Setter
public class Order implements SolvdEntity {
    private BuildingType buildingType;
    private boolean isBuildFaster;
    private boolean isDecorateInterior;

    private int calculateOrderTotalBuildingTime() {
        int buildingTimeWeeks = buildingType.getBasicWeeksToBuild();
        if(isBuildFaster) {
            buildingTimeWeeks -= (buildingTimeWeeks * BUILD_FASTER.getTermCoefficient());
        }
        if(isDecorateInterior()) {
            buildingTimeWeeks += (buildingTimeWeeks * DECORATE_INTERIOR.getTermCoefficient());
        }
        return buildingTimeWeeks;
    }

    private double calculateOrderTotalPrice() {
        double totalPrice = buildingType.getBasicPrice();
        if(isBuildFaster) {
            totalPrice += (totalPrice * BUILD_FASTER.getPriceCoefficient());
        }
        if(isDecorateInterior) {
            totalPrice += (totalPrice * DECORATE_INTERIOR.getPriceCoefficient());
        }
        return Math.ceil(totalPrice);
    }

    @Override
    public String entityToString() {
        return "ИТОГО ЗАКАЗ: \n" + buildingType.toString() + "С отделкой: " + isDecorateInterior + "\n"
                + "Строим в две смены: " + isBuildFaster  + "\n"
                + "Итого построим за: " + calculateOrderTotalBuildingTime() + " недель.\n"
                + "Итоговая стоимость: " + calculateOrderTotalPrice() + " $\n";
    }
}
