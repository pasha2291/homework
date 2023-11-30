package com.solvd.action;

import com.solvd.exception.CustomException;

public interface TotalPriceCalculatorAction {
    double calculateTotalPrice() throws CustomException;
}
