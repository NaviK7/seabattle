package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelRow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author kaa
 * @version 1.0
 */
@SpringBootTest
public class ModelRowTest {

    @Test
    void fieldTest() {
        // проверка инкапсуляции полей
        try {
            Field field = ModelRow.class.getDeclaredField("row");
            field.setAccessible(true);
            assertThat(field.getModifiers() == (Modifier.PRIVATE | Modifier.FINAL)).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void constructorTest() {
        // проверка наличия необходимого конструктора (нет смысла)
        assertThat(ModelRow.class.getConstructors().length == 1).isTrue();
    }

    @Test
    void getterTest() {
        // проверка наличия геттера
        assertThat(Arrays.stream(ModelRow.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("getRow"))).isTrue();
    }

    @Test
    void setterTest() {
        // проверка наличия сеттера
        assertThat(Arrays.stream(ModelRow.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("setRow"))).isFalse();
    }
}
