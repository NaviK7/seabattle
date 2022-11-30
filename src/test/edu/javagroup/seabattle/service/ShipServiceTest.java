package edu.javagroup.seabattle.service;

import edu.javagroup.seabattle.common.utils.CommonService;
import edu.javagroup.seabattle.model.ShipPoint;
import edu.javagroup.seabattle.service.impl.ShipServiceImpl;
import edu.javagroup.seabattle.singleton.ImReadySingleton;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * перед использованием раскомментировать классы
 * <p>
 * test -> edu.javagroup.seabattle.common.utils.CommonService
 * test -> edu.javagroup.seabattle.common.utils.impl.CommonServiceImpl
 *
 * @author kaa
 * @version 1.5
 */
@SpringBootTest
public class ShipServiceTest {

    @Autowired
    private ShipService shipService;

    @Autowired
    private CommonService commonService;

    private static final String COORDINATE_LIST_FIELD = "coordinateList";

    //------------------------------------------------------------------------------------------------------------------

    @Test
    void oopTest() {
        // проверки использования парадигм
        assertThat(ShipServiceImpl.class.getInterfaces()[0].getName().equals(ShipService.class.getName())).isTrue();
    }

    @Test
    void fieldTest() {
        // проверка, есть ли необходимые поля
        Field[] fieldArray = ShipServiceImpl.class.getDeclaredFields();
        List<String> fieldNameArray = Arrays.stream(fieldArray).map(Field::getName).collect(Collectors.toCollection(() -> new ArrayList<>(1)));
        AssertionsForClassTypes.assertThat(fieldNameArray.contains(COORDINATE_LIST_FIELD)).isTrue();
        // проверка инкапсуляции поля
        try {
            Field field = ShipServiceImpl.class.getDeclaredField(COORDINATE_LIST_FIELD);
            field.setAccessible(true);
            AssertionsForClassTypes.assertThat(field.getModifiers() == Modifier.PRIVATE).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void checkShipCountTest1() {
        // проверка на 19ти палубах по всей панели
        MinePanelSingleton.instance(commonService.getPanel19());
        assertThat(shipService.checkShipCount()).isFalse();
        // проверка на 20ти палубах по всей панели
        MinePanelSingleton.instance(commonService.getPanel20());
        assertThat(shipService.checkShipCount()).isTrue();
    }

    @Test
    void checkShipCountTest2() {
        // до начала игры
        ImReadySingleton.instance(false);
        // проверка полной заполненности
        MinePanelSingleton.instance(commonService.getPanel20());
        for (int deck = 1; deck <= 4; deck++) {
            assertThat(shipService.checkShipCount(deck) == 5 - deck).isTrue();
        }

        // проверка частичной заполненности
        MinePanelSingleton.instance(commonService.getPanel19());
        // 1 палуба - 4шт
        assertThat(shipService.checkShipCount(1) == 4).isTrue();
        // 2 палубы - 2шт
        assertThat(shipService.checkShipCount(2) == 2).isTrue(); // !!!
        // 3 палубы - 2шт
        assertThat(shipService.checkShipCount(3) == 2).isTrue();
        // 4 палубы - 1шт
        assertThat(shipService.checkShipCount(4) == 1).isTrue();

        // после начала игры
        ImReadySingleton.instance(true);
        // все корабли подбиты
        MinePanelSingleton.instance(commonService.getPanel22());
        for (int deck = 1; deck <= 4; deck++) {
            assertThat(shipService.checkShipCount(deck) == 5 - deck).isTrue();
        }
    }

    /**
     * запускать отдельно
     * <p>
     * перед запуском этого теста, сменить модификатор метода getHorizontalCoordinateList в ShipServiceImpl,
     * после положительного результата проверки, вернуть прежний модификатор
     */
    @Test
    @Disabled
    void getHorizontalCoordinateListTest() {
        assertThat(new ShipServiceImpl().getHorizontalCoordinateList(commonService.getPanel20()).size() == 110).isTrue();
    }

    /**
     * запускать отдельно
     * <p>
     * перед запуском этого теста, сменить модификатор метода getVerticalCoordinateList в ShipServiceImpl,
     * после положительного результата проверки, вернуть прежний модификатор
     */
    @Test
    @Disabled
    void getVerticalCoordinateListTest() {
        assertThat(new ShipServiceImpl().getVerticalCoordinateList(commonService.getPanel20()).size() == 110).isTrue();
    }

    /**
     * запускать отдельно
     * <p>
     * перед запуском этого теста, сменить модификатор метода getHorizontalCoordinateList и getVerticalCoordinateList в ShipServiceImpl,
     * после положительного результата проверки, вернуть прежние модификаторы
     */
    @Test
    @Disabled
    void coordinateListTest() {
        MinePanelSingleton.instance(commonService.getPanel20());
        shipService.checkShipCount();
        ShipServiceImpl shipServiceImpl = new ShipServiceImpl();
        List<ShipPoint> shipPointList = shipServiceImpl.getHorizontalCoordinateList(MinePanelSingleton.instance(null).getPanel());
        shipPointList.addAll(shipServiceImpl.getVerticalCoordinateList(MinePanelSingleton.instance(null).getPanel()));
        AtomicInteger point = new AtomicInteger();
        shipPointList.forEach(item -> assertThat(item.getPoint() == point.incrementAndGet()).isTrue());
    }

    /**
     * запускать отдельно
     * <p>
     * перед запуском этого теста, сменить модификатор метода findShipDeck в ShipServiceImpl,
     * после положительного результата проверки, вернуть прежний модификатор
     */
    @Test
    @Disabled
    void findShipDeckTest() {
        MinePanelSingleton.instance(commonService.getPanel20());
        ShipServiceImpl shipServiceImpl = new ShipServiceImpl();
        shipServiceImpl.checkShipCount();
        assertThat(shipServiceImpl.findShipDeck(4) == 1).isTrue();
        assertThat(shipServiceImpl.findShipDeck(3) == 2).isTrue();
        assertThat(shipServiceImpl.findShipDeck(2) == 3).isTrue();
        assertThat(shipServiceImpl.findShipDeck(1) == 4).isTrue();
    }
}
