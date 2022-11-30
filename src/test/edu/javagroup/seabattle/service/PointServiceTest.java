package edu.javagroup.seabattle.service;

import edu.javagroup.seabattle.common.utils.CommonService;
import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.service.impl.PanelServiceImpl;
import edu.javagroup.seabattle.service.impl.PointServiceImpl;
import edu.javagroup.seabattle.singleton.ForbiddenCellsSingleton;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * перед использованием раскомментировать классы
 * <p>
 * test -> edu.javagroup.seabattle.common.utils.CommonService
 * test -> edu.javagroup.seabattle.common.utils.impl.CommonServiceImpl
 *
 * @author kaa
 * @version 1.6
 */
@SpringBootTest
public class PointServiceTest {

    @Autowired
    private PointService pointService;

    @Autowired
    private CommonService commonService;

    private static final String PANEL_SERVICE_FIELD = "panelService";

    //------------------------------------------------------------------------------------------------------------------

    @Test
    void oopTest() {
        // проверки использования парадигм
        assertThat(PointServiceImpl.class.getInterfaces()[0].getName().equals(PointService.class.getName())).isTrue();
    }

    @Test
    void fieldTest() {
        // проверка, есть ли необходимые поля
        Field[] fieldArray = PointServiceImpl.class.getDeclaredFields();
        List<String> fieldNameArray = Arrays.stream(fieldArray).map(Field::getName).collect(Collectors.toCollection(() -> new ArrayList<>(1)));
        assertThat(fieldNameArray.contains(PANEL_SERVICE_FIELD)).isTrue();
        // проверка инкапсуляции поля
        try {
            Field field = PointServiceImpl.class.getDeclaredField(PANEL_SERVICE_FIELD);
            field.setAccessible(true);
            assertThat(field.getModifiers() == (Modifier.PRIVATE | Modifier.FINAL)).isTrue();
        } catch (NoSuchFieldException ex) {
            System.out.println(ex.getMessage());
        }

        // проверка наличия необходимого конструктора (нет смысла)
        Constructor[] constructorArray = PointServiceImpl.class.getConstructors();
        assertThat(constructorArray.length == 1).isTrue();

        // проверка наличия всех полей в конструкторе (нет смысла)
        Class[] parameterTypesArray = constructorArray[0].getParameterTypes();
        assertThat(parameterTypesArray.length == 1).isTrue();

        // проверка наличия необходимых полей (нет смысла)
        List<String> parametersTypesList = Collections.singletonList(
                parameterTypesArray[0].getName().replace("edu.javagroup.seabattle.service.P", "p")
        );
        assertThat(parametersTypesList.contains(PANEL_SERVICE_FIELD)).isTrue();
    }

    @Test
    void isClearPointTest() {
        MinePanelSingleton.instance(commonService.getPanel20());

        assertThat(pointService.isClearPoint('A', 1)).isFalse();
        assertThat(pointService.isClearPoint('A', 2)).isTrue();
    }

    @Test
    void setShipPointTest() {
        MinePanelSingleton.instance(commonService.getPanel20());

        pointService.setShipPoint('A', 1);
        assertThat(MinePanelSingleton.instance(null).getPanel().get(0).getPointElementList().get(0).getValue() == 0).isTrue();

        pointService.setShipPoint('A', 1);
        assertThat(MinePanelSingleton.instance(null).getPanel().get(0).getPointElementList().get(0).getValue() == 1).isTrue();
    }

    @Test
    void setSidePointTest() {
        MinePanelSingleton.instance(commonService.getPanel20());

        pointService.setSidePoint(Constants.MINE, 'A', 1, 0);
        assertThat(MinePanelSingleton.instance(null).getPanel().get(0).getPointElementList().get(0).getValue() == 0).isTrue();

        pointService.setSidePoint(Constants.MINE, 'A', 1, 1);
        assertThat(MinePanelSingleton.instance(null).getPanel().get(0).getPointElementList().get(0).getValue() == 1).isTrue();

        pointService.setSidePoint(Constants.MINE, 'A', 1, 2);
        assertThat(MinePanelSingleton.instance(null).getPanel().get(0).getPointElementList().get(0).getValue() == 2).isTrue();

        Exception exception = assertThrows(Exception.class, () -> {
            pointService.setSidePoint("STRANGE", 'B', 2, 2);
        });
        assertThat(exception.getMessage()).hasToString("Уточните сторону (MINE or ENEMY)");
    }

    @Test
    void setBombTest() {
        MinePanelSingleton.instance(commonService.getPanel20());

        pointService.getBomb('A', 1);
        assertThat(MinePanelSingleton.instance(null).getPanel().get(0).getPointElementList().get(0).getValue() == 2).isTrue();

        pointService.getBomb('A', 2);
        assertThat(MinePanelSingleton.instance(null).getPanel().get(0).getPointElementList().get(1).getValue() == 3).isTrue();
    }

    /**
     * запускать отдельно
     * <p>
     * перед запуском этого теста, сменить модификатор метода setSidePoint, clearAroundPoints в PointServiceImpl,
     * setSidePoint, clearAroundPoints должны быть протестированы заранее,
     * после положительного результата проверки, вернуть прежний модификатор
     */
    @Test
    @Disabled
    void clearShipPointTest() {
        PointServiceImpl pointServiceImpl = new PointServiceImpl(new PanelServiceImpl());

        // создаем пустую панель
        MinePanelSingleton.instance(commonService.getPanel00());
        // заполняем запрещенные к использованию ячейки
        ForbiddenCellsSingleton.instance(commonService.getForbidden05());
        // устанавливаем корабль, так, чтобы новые запрещенные ячейки не затронули старые
        pointServiceImpl.setShipPoint('E', 5);
        // очищаем поле, вместе с ним уйдут и новые запрещенные ячейки
        pointServiceImpl.clearShipPoint('E', 5);
        // проверяем поле на пустоту
        assertThat(pointServiceImpl.isClearPoint('E', 5)).isTrue();
        // проверяем, чтобы карта запрещенных ячеек была пуста (ведь поле уже пусто полностью)
        assertThat(ForbiddenCellsSingleton.instance(null).getForbiddenCellsMap().size() == 0).isTrue();

        // создаем пустую панель
        MinePanelSingleton.instance(commonService.getPanel00());
        // заполняем запрещенные к использованию ячейки
        ForbiddenCellsSingleton.instance(commonService.getForbidden05());
        // устанавливаем палубы
        pointServiceImpl.setShipPoint('E', 5);
        pointServiceImpl.setShipPoint('E', 6);
        // устанавливаем корабль, так, чтобы новые запрещенные ячейки не затронули старые
        pointServiceImpl.setShipPoint('J', 10);
        // очищаем поле, вместе с ним уйдут и новые запрещенные ячейки
        pointServiceImpl.clearShipPoint('J', 10);
        // проверяем поле на пустоту
        assertThat(pointServiceImpl.isClearPoint('J', 10)).isTrue();
        // проверяем, чтобы карта запрещенных ячеек содержала старые (ведь поле не пусто, есть другие палубы кораблей)
        assertThat(ForbiddenCellsSingleton.instance(null).getForbiddenCellsMap().size() == 10).isTrue();
    }

    /**
     * запускать отдельно
     * <p>
     * перед запуском этого теста, сменить модификатор метода isOccupiedCell в PointServiceImpl,
     * после положительного результата проверки, вернуть прежний модификатор
     */
    @Test
    @Disabled
    void isOccupiedCellTest() {
        MinePanelSingleton.instance(commonService.getPanel20());
        assertThat(new PointServiceImpl(new PanelServiceImpl()).isOccupiedCell('A', 1, 1)).isTrue();
        assertThat(new PointServiceImpl(new PanelServiceImpl()).isOccupiedCell('A', 2, 0)).isTrue();
    }

    /**
     * запускать отдельно
     * <p>
     * перед запуском этого теста, сменить модификатор метода setForbiddenCells в PointServiceImpl,
     * после положительного результата проверки, вернуть прежний модификатор
     */
    @Test
    @Disabled
    void setForbiddenCellsTest() {
        // заполняем пустыми картами и панелями
        ForbiddenCellsSingleton.instance(commonService.getForbidden00());
        MinePanelSingleton.instance(commonService.getPanel00());

        HorizontalLine horizontalLine;
        PointElement pointElement;
        List<HorizontalLine> horizontalLineList = MinePanelSingleton.instance(null).getPanel();

        // устанавливаем B02
        horizontalLine = horizontalLineList.get(1);
        pointElement = horizontalLine.getPointElementList().get(1);
        pointElement.setValue(1);

        // устанавливаем D04
        horizontalLine = horizontalLineList.get(3);
        pointElement = horizontalLine.getPointElementList().get(3);
        pointElement.setValue(1);

        // устанавливаем E04
        horizontalLine = horizontalLineList.get(4);
        pointElement = horizontalLine.getPointElementList().get(3);
        pointElement.setValue(1);

        new PointServiceImpl(new PanelServiceImpl()).setForbiddenCells();
        Map<String, Boolean> map = ForbiddenCellsSingleton.instance(null).getForbiddenCellsMap();

        // проверяем размерность заполнения карты
        assertThat(map.size() == 14).isTrue();

        // проверяем корректность установки ключей
        assertThat(map.getOrDefault("A01", false)).isTrue(); // окружаем B02 запретами по диагонали
        assertThat(map.getOrDefault("A03", false)).isTrue(); // окружаем B02 запретами по диагонали
        assertThat(map.getOrDefault("B02", false)).isTrue(); // устанавливаем в эту ячейку (B02)
        assertThat(map.getOrDefault("C01", false)).isTrue(); // окружаем B02 запретами по диагонали
        assertThat(map.getOrDefault("C03", false)).isTrue(); // окружаем B02 запретами по диагонали
        assertThat(map.getOrDefault("C05", false)).isTrue();
        assertThat(map.getOrDefault("D03", false)).isTrue();
        assertThat(map.getOrDefault("D04", false)).isTrue();
        assertThat(map.getOrDefault("D05", false)).isTrue();
        assertThat(map.getOrDefault("E03", false)).isTrue();
        assertThat(map.getOrDefault("E04", false)).isTrue();
        assertThat(map.getOrDefault("E05", false)).isTrue();
        assertThat(map.getOrDefault("F03", false)).isTrue();
        assertThat(map.getOrDefault("F05", false)).isTrue();
    }
}
