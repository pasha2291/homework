package com.solvd.reflection.entity.model;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodModel {
    private Method method;
    private String name;
    private String accessModifier;
    private String returnType;
    private List<String> parameters;

    public MethodModel(Method method) {
        this.method = method;
        accessModifier = getAccessModifier();
        parameters = Arrays.stream(method.getParameterTypes()).map(Class::getSimpleName).collect(Collectors.toList());
        name = method.getName();
        returnType = method.getReturnType().getSimpleName();
    }

    public String getName() {
        return name;
    }

    private String getAccessModifier() {
        return Arrays.stream(method.toString().split(" ")).findFirst().orElse("Unable to find");
    }

    @Override
    public String toString() {
        return "Method[name = " + name + ", access modifier = " + accessModifier + ", return type = " +
                returnType + ", parameters = " + parameters + "]";
    }
}
