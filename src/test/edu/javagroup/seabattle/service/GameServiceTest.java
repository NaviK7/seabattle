package edu.javagroup.seabattle.service;

import edu.javagroup.seabattle.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author kaa
 * @version 1.6
 */
@SpringBootTest
public class GameServiceTest {

    private static final String PANEL_SERVICE_FIELD = "panelService";
    private static final String POINT_SERVICE_FIELD = "pointService";
    private static final String SHIP_SERVICE_FIELD = "shipService";

    @Test
    void oopTest() {
        // проверки использования парадигм
        assertThat(GameServiceImpl.class.getInterfaces()[0].getName().equals(GameService.class.getName())).isTrue();
    }

    @Test
    void fieldTest() {
        // проверка, есть ли необходимые поля
        Field[] fieldArray = GameServiceImpl.class.getDeclaredFields();
        List<String> fieldNameArray = Arrays.stream(fieldArray).map(Field::getName).collect(Collectors.toCollection(() -> new ArrayList<>(3)));
        assertThat(fieldNameArray.contains(PANEL_SERVICE_FIELD)).isTrue();
        assertThat(fieldNameArray.contains(POINT_SERVICE_FIELD)).isTrue();
        assertThat(fieldNameArray.contains(SHIP_SERVICE_FIELD)).isTrue();

        // проверка инкапсуляции поля
        try {
            Field field = GameServiceImpl.class.getDeclaredField(PANEL_SERVICE_FIELD);
            field.setAccessible(true);
            assertThat(field.getModifiers() == (Modifier.PRIVATE | Modifier.FINAL)).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }

        // проверка инкапсуляции поля
        try {
            Field field = GameServiceImpl.class.getDeclaredField(POINT_SERVICE_FIELD);
            field.setAccessible(true);
            assertThat(field.getModifiers() == (Modifier.PRIVATE | Modifier.FINAL)).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }

        // проверка инкапсуляции поля
        try {
            Field field = GameServiceImpl.class.getDeclaredField(SHIP_SERVICE_FIELD);
            field.setAccessible(true);
            assertThat(field.getModifiers() == (Modifier.PRIVATE | Modifier.FINAL)).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void constructorTest() {
        // проверка наличия необходимого конструктора (нет смысла)
        Constructor[] constructorArray = GameServiceImpl.class.getConstructors();
        assertThat(constructorArray.length == 1).isTrue();

        // проверка наличия всех полей в конструкторе (нет смысла)
        Class[] parameterTypesArray = constructorArray[0].getParameterTypes();
        assertThat(parameterTypesArray.length == 3).isTrue();

        // проверка наличия необходимых полей (нет смысла)
        List<String> parametersTypesList = Arrays.asList(
                parameterTypesArray[0].getName(), parameterTypesArray[1].getName(), parameterTypesArray[2].getName()
        );
        parametersTypesList.replaceAll(
                item -> item.replace(item.substring(0, item.lastIndexOf(".") + 1) + "P", "p")
                        .replace(item.substring(0, item.lastIndexOf(".") + 1) + "S", "s")
        );
        assertThat(parametersTypesList.contains(PANEL_SERVICE_FIELD)).isTrue();
        assertThat(parametersTypesList.contains(POINT_SERVICE_FIELD)).isTrue();
        assertThat(parametersTypesList.contains(SHIP_SERVICE_FIELD)).isTrue();
    }
}
