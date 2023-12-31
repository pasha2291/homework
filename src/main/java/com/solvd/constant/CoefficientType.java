package com.solvd.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CoefficientType {
    BUILD_FASTER(0.45, 0.5, 0.25),
    DECORATE_INTERIOR(0.5, 0.2, 0.25);

    private double priceCoefficient;
    private double termCoefficient;
    private double companyProfit;
}
