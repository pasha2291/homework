package com.solvd.menu;

import com.solvd.constant.TableType;
import lombok.experimental.UtilityClass;

import static com.solvd.service.CustomLogger.logInfo;

@UtilityClass
public class Menu {
    public static void printInitialMenuMessage() {
        String message = "Вас приветствует меню базы данных.\n Введите пожалуйста название таблицы с которой хотите работать: >>>";
        logInfo(message);
    }

    public static void printMainMenu(TableType type) {
        String message = "Для таблицы " + type.name() + " Вам доступны следующие опции:\n 1. Показать все записи таблицы.\n " +
                "2. Удалить запись по id.\n3. Добавить записи в таблицу из ресурсов (DOM).\n" +
                "4. Добавить записи в таблицу из ресурсов (JAXP).\n";
        logInfo(message);
    }

    public static void printIdRequest() {
        String message = "Введите id записи, которую Вы хотите удалить: >>>";
        logInfo(message);
    }
}
