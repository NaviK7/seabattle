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
 * @version 1.3
 */
@SpringBootTest
public class PointElementTest {

    @Test
    void oopTest() {
        // проверки использования парадигм
        assertThat(PointElement.class.getSuperclass().getSimpleName().equals(ModelValue.class.getSimpleName())).isTrue();
        assertThat(PointElement.class.getGenericInterfaces()[0].getTypeName().contains(Comparable.class.getSimpleName())).isTrue();
    }

    @Test
    void fieldTest() {
        // проверка инкапсуляции полей
        try {
            Field field = PointElement.class.getDeclaredField("col");
            field.setAccessible(true);
            assertThat(field.getModifiers() == (Modifier.PRIVATE | Modifier.FINAL)).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void constructorTest() {
        // проверка наличия необходимого конструктора (нет смысла)
        assertThat(PointElement.class.getConstructors().length == 1).isTrue();
        // проверка порядка параметров конструктора
        PointElement pointElement = new PointElement(1, 2);
        assertThat(pointElement.getCol() == 1).isTrue();
        assertThat(pointElement.getValue() == 2).isTrue();
    }

    @Test
    void getterTest() {
        // проверка наличия геттера
        assertThat(Arrays.stream(PointElement.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("getCol"))).isTrue();
    }

    @Test
    void setterTest() {
        // проверка наличия сеттера
        assertThat(Arrays.stream(PointElement.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("setСol"))).isFalse();
    }

    @Test
    void compareToTest() {
        // проверка наличия метода compareTo
        assertThat(Arrays.stream(PointElement.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("compareTo"))).isTrue();
    }
}
