package com.solvd.entity;

import com.solvd.action.PrintAction;
import com.solvd.action.ProfitAction;
import com.solvd.action.SolvdEntityAction;
import com.solvd.action.TotalPriceCalculatorAction;
import lombok.AllArgsConstructor;

import static com.solvd.constant.CoefficientType.BUILD_FASTER;
import static com.solvd.constant.CoefficientType.DECORATE_INTERIOR;

@AllArgsConstructor
public final class Profit implements SolvdEntityAction, TotalPriceCalculatorAction, PrintAction, ProfitAction {
    private Order order;

    @Override
    public double getProfitFromBuilding() {
        return order.getBuildingType().getBasicPrice() * order.getBuildingType().getNetProfit();
    }

    @Override
    public double getProfitFromBuildFast() {
        double profit = 0.0;
        if(order.isBuildFaster()) {
            double buildFastCost = order.getBuildingType().getBasicPrice() * BUILD_FASTER.getPriceCoefficient();
            profit = buildFastCost * BUILD_FASTER.getCompanyProfit();
        }
        return profit;
    }

    @Override
    public double getProfitFromInteriorWork() {
        double profit = 0.0;
        if(order.isDecorateInterior()){
            double interiorWorkProfit = order.getBuildingType().getBasicPrice() * DECORATE_INTERIOR.getPriceCoefficient();
            profit = interiorWorkProfit * DECORATE_INTERIOR.getCompanyProfit();
        }
        return profit;
    }

    @Override
    public double calculateTotalPrice() {
        return getProfitFromBuilding() + getProfitFromBuildFast() + getProfitFromInteriorWork();
    }

    @Override
    public void printEntity() {
        System.out.println(this.entityToString());
    }

    @Override
    public final String entityToString() {
        return "Заказ принесет компании чистую прибыль: " + calculateTotalPrice() + " $\n"
                + "Включая: \n"
                + "За работу в две смены: " + getProfitFromBuildFast() + " $\n"
                + "За внутреннюю отделку: " + getProfitFromInteriorWork() + " $\n";
    }
}
