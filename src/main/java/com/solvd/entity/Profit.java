package com.solvd.entity;

import com.solvd.action.PrintAction;
import com.solvd.action.ProfitAction;
import com.solvd.action.SolvdEntityAction;
import com.solvd.action.TotalPriceCalculatorAction;
import com.solvd.exception.CustomException;
import com.solvd.exception.InvalidBuildFastProfitException;
import com.solvd.exception.InvalidInteriorWorkProfitException;
import com.solvd.exception.InvalidTotalPriceCalculationException;
import lombok.AllArgsConstructor;

import static com.solvd.constant.CoefficientType.getBuildFasterCoefficients;
import static com.solvd.constant.CoefficientType.getDecorateInteriorCoefficients;
import static com.solvd.service.CustomLogger.logInfo;

@AllArgsConstructor
public final class Profit implements SolvdEntityAction, TotalPriceCalculatorAction, PrintAction, ProfitAction {
    private Order order;

    @Override
    public double getProfitFromBuilding() {
        return order.getBuildingType().getBasicPrice() * order.getBuildingType().getNetProfit();
    }

    @Override
    public double getProfitFromBuildFast() throws InvalidBuildFastProfitException {
        double profit = 0.0;
        if(order.isBuildFaster()) {
            double buildFastCost = order.getBuildingType().getBasicPrice() * getBuildFasterCoefficients().get(0);
            profit = buildFastCost * getBuildFasterCoefficients().get(2);
        }
        if(profit < 0.0) {
            throw new InvalidBuildFastProfitException("Profit from build fast work may not be less than 0.0: " + profit);
        }
        return profit;
    }

    @Override
    public double getProfitFromInteriorWork() throws InvalidInteriorWorkProfitException {
        double profit = 0.0;
        if(order.isDecorateInterior()){
            double interiorWorkProfit = order.getBuildingType().getBasicPrice() * getDecorateInteriorCoefficients().get(0);
            profit = interiorWorkProfit * getDecorateInteriorCoefficients().get(2);
        }
        if(profit < 0.0) {
            throw new InvalidInteriorWorkProfitException("Profit from interior work may not be less than 0.0: " + profit);
        }
        return profit;
    }

    @Override
    public double calculateTotalPrice() throws CustomException {
        double totalPrice = getProfitFromBuilding() + getProfitFromBuildFast() + getProfitFromInteriorWork();
        if(totalPrice <= 0.0) {
            throw new InvalidTotalPriceCalculationException("Total price may not be less or equal 0.0: " + totalPrice);
        }
        return totalPrice;
    }

    @Override
    public void printEntity() throws CustomException {
        logInfo(this.entityToString());
    }

    @Override
    public final String entityToString() throws CustomException {
        return "Заказ принесет компании чистую прибыль: " + calculateTotalPrice() + " $\n"
                + "Включая: \n"
                + "За работу в две смены: " + getProfitFromBuildFast() + " $\n"
                + "За внутреннюю отделку: " + getProfitFromInteriorWork() + " $\n";
    }
}
