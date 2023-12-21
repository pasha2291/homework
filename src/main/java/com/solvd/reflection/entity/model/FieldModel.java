package com.solvd.reflection.entity.model;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldModel {
    private Field field;
    private String name;
    private String accessModifier;
    private String type;

    public FieldModel(Field field) {
        this.field = field;
        accessModifier = getAccessModifier();
        type = field.getType().getSimpleName();
        name = field.getName();
    }

    public String getName() {
        return name;
    }

    private String getAccessModifier() {
        return Arrays.stream(field.toString().split(" ")).findFirst().orElse("Unable to find");
    }

    @Override
    public String toString() {
        return "Field[name = " + name + ", access modifier = " + accessModifier + ", type = " + type + "]";
    }
}
