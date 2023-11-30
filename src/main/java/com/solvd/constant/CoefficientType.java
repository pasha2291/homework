package com.solvd.constant;

import com.solvd.service.custom_linked_list.CustomLinkedList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class CoefficientType {
    private static final String BUILD_FASTER_COEFFICIENT = "BUILD_FASTER";
    private static final String DECORATE_INTERIOR_COEFFICIENT = "DECORATE_INTERIOR";
    private static final Map<String, CustomLinkedList<Double>> coefficients = new HashMap<>();

    static {
        CustomLinkedList<Double> buildFasterCoefficients = new CustomLinkedList<>();
        buildFasterCoefficients.add(0.45);
        buildFasterCoefficients.add(0.5);
        buildFasterCoefficients.add(0.25);
        CustomLinkedList<Double> decorateInteriorCoefficients = new CustomLinkedList<>();
        decorateInteriorCoefficients.add(0.5);
        decorateInteriorCoefficients.add(0.2);
        decorateInteriorCoefficients.add(0.25);
        coefficients.put(BUILD_FASTER_COEFFICIENT, buildFasterCoefficients);
        coefficients.put(DECORATE_INTERIOR_COEFFICIENT, decorateInteriorCoefficients);
    }

    public static CustomLinkedList<Double> getBuildFasterCoefficients() {
        return coefficients.get(BUILD_FASTER_COEFFICIENT);
    }

    public static CustomLinkedList<Double> getDecorateInteriorCoefficients() {
        return coefficients.get(DECORATE_INTERIOR_COEFFICIENT);
    }
}
