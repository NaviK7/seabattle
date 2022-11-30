package edu.javagroup.seabattle.util;

/**
 * Утилитный класс StringUtils,
 * проверяет приходящую строку в виде CharSequence
 * на соответствие параметров
 *
 * @author Andriy Gryshchenko
 * @version 1.0
 */
public class StringUtils {

    /**
     * проверка: является ли пришедшая строка null или ее длина равна нулю
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    /**
     * инвертированный ответ метода isEmpty -
     * является ли пришедшая строка null или ее длина равна нулю
     */
    public static boolean isNotEmpty(CharSequence ip) {
        return !isEmpty(ip);
    }

    /**
     * возвращает предыдущий символ от пришедшего
     */
    public static char letterBefore(char symbol) {
        return (char) (symbol - 1);
    }

    /**
     * возвращает следующий символ от пришедшего
     */
    public static char letterAfter(char symbol) {
        return (char) (symbol + 1);
    }
}
