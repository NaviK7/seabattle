package edu.javagroup.seabattle.util;

/**
 * Утилитный класс NumberUtils,
 * проверяет приходящую строку с IP адресом на соответствие параметров
 *
 * @author Andriy Gryshchenko
 * @version 1.0
 */
public class NumberUtils {

    /**
     * проверки строки по параметрам
     */
    public static boolean isNumber(String str) {
        //проверка строки на пустоту
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        //проверка строуи на содержание прочерка и точки
        if (str.contains("-") || (str.contains("."))) {
            return false;
        }
        //проверка строуи на содержание чисел только (включая нуль)
        for (int i = 0; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        return true;
    }

    /**
     * проверка приходящего числа на
     * величину и если нужно добавление нуля перд ним
     */
    public static String currentNumber(int num) {
        return (num < 10) ? ("0" + num) : String.valueOf(num);
    }

    /**
     * проверка предидущего числа на величину и если нужно добавление нуля
     * перд ним, используя метод  currentNumber
     */
    public static String numberBefore(int num) {
        int num1 = num - 1;
        return NumberUtils.currentNumber(num1);
    }

    /**
     * проверка следующего числа на величину и если нужно добавление
     * нуля перд ним, используя метод  currentNumber
     */
    public static String numberAfter(int num) {
        int num1 = num + 1;
        return NumberUtils.currentNumber(num1);
    }
}

