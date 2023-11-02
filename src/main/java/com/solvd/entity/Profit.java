package com.solvd.entity;

import lombok.AllArgsConstructor;

import static com.solvd.constant.CoefficientType.BUILD_FASTER;
import static com.solvd.constant.CoefficientType.DECORATE_INTERIOR;

@AllArgsConstructor
public class Profit implements SolvdEntity {
    private Order order;

    private double getProfitFromBuilding() {
        return order.getBuildingType().getBasicPrice() * order.getBuildingType().getNetProfit();
    }

    private double getProfitFromBuildFast() {
        double profit = 0.0;
        if(order.isBuildFaster()) {
            double buildFastCost = order.getBuildingType().getBasicPrice() * BUILD_FASTER.getPriceCoefficient();
            profit = buildFastCost * BUILD_FASTER.getCompanyProfit();
        }
        return profit;
    }

    private double getProfitFromInteriorWork() {
        double profit = 0.0;
        if(order.isDecorateInterior()){
            double interiorWorkProfit = order.getBuildingType().getBasicPrice() * DECORATE_INTERIOR.getPriceCoefficient();
            profit = interiorWorkProfit * DECORATE_INTERIOR.getCompanyProfit();
        }
        return profit;
    }

    private double getTotalProfitFromOrder() {
        return getProfitFromBuilding() + getProfitFromBuildFast() + getProfitFromInteriorWork();
    }

    @Override
    public String entityToString() {
        return "Заказ принесет компании чистую прибыль: " + getTotalProfitFromOrder() + " $\n"
                + "Включая: \n"
                + "За работу в две смены: " + getProfitFromBuildFast() + " $\n"
                + "За внутреннюю отделку: " + getProfitFromInteriorWork() + " $\n";
    }
}
