package com.solvd.reflection;

import com.solvd.reflection.entity.TestEntity;
import lombok.experimental.UtilityClass;

import static com.solvd.reflection.ReflectionAction.instantiateClassByDefaultConstructor;
import static com.solvd.reflection.ReflectionPrinter.printConstructorsInfo;
import static com.solvd.reflection.ReflectionPrinter.printFieldsInfo;
import static com.solvd.reflection.ReflectionPrinter.printMethodsInfo;
import static com.solvd.reflection.ReflectionPrinter.printToStringMethod;

@UtilityClass
public class ReflectionRunner {
    public static void main(String[] args) {
        printConstructorsInfo(TestEntity.class);
        printFieldsInfo(TestEntity.class);
        printMethodsInfo(TestEntity.class);

        TestEntity testEntity = instantiateClassByDefaultConstructor(TestEntity.class);
        printToStringMethod(testEntity);
    }
}
