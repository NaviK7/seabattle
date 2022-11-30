package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelRow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author kaa
 * @version 1.3
 */
@SpringBootTest
public class HorizontalLineTest {

    @Test
    void oopTest() {
        // проверки использования парадигм
        assertThat(HorizontalLine.class.getSuperclass().getSimpleName().equals(ModelRow.class.getSimpleName())).isTrue();
        assertThat(HorizontalLine.class.getGenericInterfaces()[0].getTypeName().contains(Comparable.class.getSimpleName())).isTrue();
    }

    @Test
    void fieldTest() {
        // проверка инкапсуляции полей
        try {
            Field field = HorizontalLine.class.getDeclaredField("pointElementList");
            field.setAccessible(true);
            assertThat(field.getModifiers() == Modifier.PRIVATE).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void constructorTest() {
        // проверка наличия необходимого конструктора (нет смысла)
        assertThat(HorizontalLine.class.getConstructors().length == 1).isTrue();
    }

    @Test
    void getterTest() {
        // проверка наличия геттера
        assertThat(Arrays.stream(HorizontalLine.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("getPointElementList"))).isTrue();
    }

    @Test
    void setterTest() {
        // проверка наличия сеттера
        assertThat(Arrays.stream(HorizontalLine.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("setPointElementList"))).isTrue();
    }

    @Test
    void compareToTest() {
        // проверка наличия метода compareTo
        assertThat(Arrays.stream(HorizontalLine.class.getMethods()).anyMatch(method -> method.getName().equalsIgnoreCase("compareTo"))).isTrue();
    }

    @Test
    void horizontalLineTest() {
        HorizontalLine horizontalLine = new HorizontalLine('Z');
        // проверка сеттера поля (параметр конструктора)
        assertThat(horizontalLine.getRow() == 'Z').isTrue();
        List<PointElement> pointElementList = horizontalLine.getPointElementList();
        // проверка размерности списка
        assertThat(pointElementList.size() == 10).isTrue();
        for (int i = 1; i < pointElementList.size(); i++) {
            PointElement pointElement = pointElementList.get(i - 1);
            // проверка назначаемых параметров
            assertThat(pointElement.getCol() == i).isTrue();
            assertThat(pointElement.getValue() == 0).isTrue();
        }
    }
}
