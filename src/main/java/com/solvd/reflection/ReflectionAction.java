package com.solvd.reflection;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ReflectionAction {

    public static <T> List<Field> getFieldsInformation(Class<T> tClass) {
        return Arrays.stream(tClass.getDeclaredFields()).collect(Collectors.toList());
    }

    public static <T> List<Method> getDeclaredMethodsInformation(Class<T> tClass) {
        return Arrays.stream(tClass.getDeclaredMethods()).collect(Collectors.toList());
    }

    public static <T> List<Constructor> getDeclaredConstructors(Class<T> tClass) {
        return Arrays.stream(tClass.getDeclaredConstructors()).collect(Collectors.toList());
    }

    @SneakyThrows
    public static <T> T instantiateClassByDefaultConstructor(Class<T> tClass) {
        Constructor defaultConstructor = getDeclaredConstructors(tClass)
                .stream()
                .filter(constructor -> constructor.getParameterCount() == 0)
                .findFirst()
                .orElseThrow();
        return  (T)defaultConstructor.newInstance();
    }
}
