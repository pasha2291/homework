package com.solvd.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Message {
    public static final String SAY_HELLO;
    public static final String BUILD_OPTIONS;
    public static final String BUILD_FASTER;
    public static final String DECORATE_INTERIOR;
    public static final String INPUT_VARIANT;
    public static final String ERROR;
    public static final String OPTION_YES;
    public static final String OPTION_NO;

    static {
        SAY_HELLO = "Добрый день! Вас приветствует строительная организация!";
        BUILD_OPTIONS = "В данный момент для строительства доступны следующие объекты:";
        BUILD_FASTER = "Ммм, %s недель! Хотите построить объект быстрее?!";
        DECORATE_INTERIOR = "Отлично! Последний вопрос - дом хотите с внутренней отделкой?";
        INPUT_VARIANT = "Введите один из номеров вариантов, который Вам подходит >>>";
        ERROR = "Некорректный ввод, пожалуйста введите номер нужного Вам варианта!";
        OPTION_YES = "1. Да, конечно!";
        OPTION_NO = "2. Нет, не надо!";
    }
}
