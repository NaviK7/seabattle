package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelValue;
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
public class ModelValueTest {

    @Test
    void fieldTest() {
        // проверка инкапсуляции полей
        try {
            Field field = ModelValue.class.getDeclaredField("value");
            field.setAccessible(true);
            assertThat(field.getModifiers() == (Modifier.PRIVATE)).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void constructorTest() {
        // проверка наличия необходимого конструктора (нет смысла)
        assertThat(ModelValue.class.getConstructors().length == 1).isTrue();
    }

    @Test
    void getterTest() {
        // проверка наличия геттера
        assertThat(Arrays.stream(ModelValue.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("getValue"))).isTrue();
    }

    @Test
    void setterTest() {
        // проверка наличия сеттера
        assertThat(Arrays.stream(ModelValue.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("setValue"))).isTrue();
    }
}
