package com.solvd.reflection;

import com.solvd.reflection.entity.model.ConstructorModel;
import com.solvd.reflection.entity.model.FieldModel;
import com.solvd.reflection.entity.model.MethodModel;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

import static com.solvd.reflection.ReflectionAction.getDeclaredConstructors;
import static com.solvd.reflection.ReflectionAction.getDeclaredMethodsInformation;
import static com.solvd.reflection.ReflectionAction.getFieldsInformation;

@UtilityClass
public class ReflectionPrinter {
    public static <T> void printFieldsInfo(Class<T> tClass) {
        System.out.println("Information about fields of " + tClass.toString() + ":");
        List<Field> fieldList = getFieldsInformation(tClass);
        fieldList.stream().map(FieldModel::new).sorted(Comparator.comparing(FieldModel::getName)).forEach(System.out::println);
        System.out.println();
    }

    public static <T> void printMethodsInfo(Class<T> tClass) {
        System.out.println("Information about methods of " + tClass.toString() + ":");
        List<Method> methodList = getDeclaredMethodsInformation(tClass);
        methodList.stream().map(MethodModel::new).sorted(Comparator.comparing(MethodModel::getName)).forEach(System.out::println);
        System.out.println();
    }

    public static <T> void printConstructorsInfo(Class<T> tClass) {
        System.out.println("Information about constructors of " + tClass.toString() + ":");
        List<Constructor> constructorList = getDeclaredConstructors(tClass);
        constructorList.stream().map(ConstructorModel::new).sorted(Comparator.comparing(ConstructorModel::getName)).forEach(System.out::println);
        System.out.println();
    }

    @SneakyThrows
    public static void printToStringMethod(Object object) {
        Method toString = object.getClass().getDeclaredMethod("toString");
        System.out.println(toString.invoke(object));
    }
}
