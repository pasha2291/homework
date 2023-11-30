package com.solvd.lambda_function;

import java.util.function.BiFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

public class Functions {
    public static final Function<String, String> ADD_NEW_LINE = (string) -> string + " \n";
    public static final BiFunction<Double, Double, Double> SUM_TWO_ARGUMENTS = Double::sum;
    public static final BiFunction<Double, Double, Double> MULTIPLY = (first, second) -> first * second;
    public static final DoubleToIntFunction CAST_TO_INT = (first) -> (int)first;
    public static final TriFunction<Double, Double, Double, Double> SUM_THREE_ARGUMENTS = (first, second, third) -> first + second + third;
}
