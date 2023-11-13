package com.solvd.constant;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

@UtilityClass
public class Message {
    private static final Map<String, List<Set<String>>> messages = new HashMap<>();

    public static final String SAY_HELLO = "SAY_HELLO";
    public static final String BUILD_OPTIONS = "BUILD_OPTIONS";
    public static final String BUILD_FASTER = "BUILD_FASTER";
    public static final String DECORATE_INTERIOR = "DECORATE_INTERIOR";
    public static final String INPUT_VARIANT = "INPUT_VARIANT";
    public static final String ERROR = "ERROR";
    public static final String RESTART_APPLICATION = "RESTART_APPLICATION";
    public static final String OPTION_YES = "OPTION_YES";
    public static final String OPTION_NO = "OPTION_NO";

    static {
        messages.put(SAY_HELLO, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("Добрый день! Вас приветствует строительная организация!")))));
        messages.put(BUILD_OPTIONS, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("В данный момент для строительства доступны следующие объекты:")))));
        messages.put(BUILD_FASTER, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("Ммм, %s недель! Хотите построить объект быстрее?!")))));
        messages.put(DECORATE_INTERIOR, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("Отлично! Последний вопрос - дом хотите с внутренней отделкой?")))));
        messages.put(INPUT_VARIANT, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("Введите один из номеров вариантов, который Вам подходит >>>")))));
        messages.put(ERROR, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("При выполнении программы возникла ошибка:")))));
        messages.put(RESTART_APPLICATION, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("Перезапустите программу!")))));
        messages.put(OPTION_YES, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("1. Да, конечно!")))));
        messages.put(OPTION_NO, new ArrayList<>(Arrays.asList(new HashSet<>(Arrays.asList("2. Нет, не надо!")))));
    }

    public static String getMessage(String message) {
        Queue<String> queue = new PriorityQueue<>(new LinkedList<>(Arrays.asList(messages.get(message).get(0).stream().findFirst().orElse("error"))));
        return queue.poll();
    }
}
