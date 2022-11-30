package edu.javagroup.seabattle.util;

import java.util.Arrays;

import static edu.javagroup.seabattle.constants.Constants.LOCALHOST;

/**
 * Утилитный класс IpAddressUtils,
 * проверяет валидность приходящей строки с IP адресо
 *
 * @author Andriy Gryshchenko
 * @version 1.0
 */
public class IpAddressUtils {

    /**
     * проверка строки с IP на соответствие параметрам
     */
    public static boolean isIpAddress(String ip) {
        //проверка строки на пустоту
        if (StringUtils.isEmpty(ip)) {
            return false;
        }
        //проверка строки на длину, не должна превышать 15 символов
        if (ip.length() > 15) {
            return false;
        }
        //проверка длины массива
        String[] strArr = ip.split("\\.");
        if (strArr.length != 4) {
            return false;
        }
        //инициализация массива чисел из масс. стринга
        int[] temp = new int[strArr.length];
        //проверка массива на содержание только чисел
        for (int i = 0; i < strArr.length; i++) {
            if (!NumberUtils.isNumber(strArr[i])) {
                return false;
            }
            //положить масив строк в массив чисел temp
            temp[i] = Integer.parseInt(strArr[i]);
        }
        //проверка массива temp на еквивал-ть запретному LOCALHOST
        if (Arrays.equals(temp, LOCALHOST)) {
            return false;
        }
        //проверяю численный массив строки, при помощи метода isOutOfRange
        for (int i = 0; i < temp.length; i++) {
            if (isOutOfRange(i, temp[i])) {
                return false;
            }
        }
        // в конце метода вернуть true,
        return !ip.endsWith(".");
    }

    /**
     * проверка массива на диапазон 0-255,
     * где значение в 0-ом индексе не может быть равным 0
     */
    public static boolean isOutOfRange(int index, int elementArray) {
        return index == 0 ?
                !(elementArray > 0 && elementArray <= 255)
                : !(elementArray >= 0 && elementArray <= 255);
    }
}
