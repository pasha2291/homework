package com.solvd.reflection.entity.model;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorModel {
    private Constructor constructor;
    private String name;
    private String accessModifier;
    private List<String> parameters;

    public ConstructorModel(Constructor constructor) {
        this.constructor = constructor;
        accessModifier = getAccessModifier();
        name = Arrays.stream(constructor.getName().split("\\."))
                .filter(str -> Character.isUpperCase(str.charAt(0))).findFirst().orElse("Unable to find");
        parameters = Arrays.stream(constructor.getParameterTypes()).map(Class::getSimpleName).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    private String getAccessModifier() {
        return Arrays.stream(constructor.toString().split(" ")).findFirst().orElse("Unable to find");
    }

    @Override
    public String toString() {
        return "Constructor[name = " + name + ", access modifier = " + accessModifier + ", parameters = " + parameters + "]";
    }
}
