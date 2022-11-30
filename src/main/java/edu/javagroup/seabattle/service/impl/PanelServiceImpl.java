package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.exception.SideNotFoundException;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.service.PanelService;
import edu.javagroup.seabattle.singleton.EnemyPanelSingleton;
import edu.javagroup.seabattle.singleton.ImReadySingleton;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static edu.javagroup.seabattle.constants.Constants.ENEMY;
import static edu.javagroup.seabattle.constants.Constants.MINE;

/**
 * Класс PanelServiceImpl имплементация интерфейса PanelService,
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
@Component
public class PanelServiceImpl implements PanelService {

    /**
     * имплементация интерфейса PanelService
     * метод: isPanelEmpty
     * счиает количество пустых ячеек игрового поля
     */
    @Override
    public boolean isPanelEmpty() {
        //вызов метода, который  считает количество PointElement с value == 0 в коллекции List<HorizontalLine>
        return countPointElements(0, MINE) == 100;
    }

    /**
     * имплементация интерфейса PanelService
     * метод: isFullMinePanel
     * определяет заполненность игрового поля кораблями
     */
    @Override
    public boolean isFullMinePanel() {
        //вызов метода, который  считает количество PointElement с value == 1 в коллекции List<HorizontalLine>
        return countPointElements(1, MINE) == 20;

    }

    /**
     * имплементация интерфейса PanelService
     * метод: howMuchIsLeft
     * подсчет подбитых кораблей игрового поля
     */
    @Override
    public int howMuchIsLeft(String side) {
        /*инициаялизаци переменной значением ,которое возвращает метод,
         который  считает количество PointElement с value == 2 в коллекции List<HorizontalLine>
         */
        int countValue = countPointElements(2, side);
        //создаем перемнную , которая равна по модулю countValue
        int posutivResalt = countValue > 20 ? countValue - 20 : 20 - countValue;
        //в зависимости от состояния ImReadySingleton, возвраем необходимое значение
        return ImReadySingleton.instance(null).imReady() ? posutivResalt : 0;
    }

    /**
     * имплементация интерфейса PanelService
     * метод: checkEndGame
     * проверяет все ли корабли подбиты на игровом поле
     */
    @Override
    public boolean checkEndGame(String side) {
        return countPointElements(2, side) == 20;
    }

    /**
     * метод: countPointElements
     * считает в зависимости стороны игрового поля количество PointElement
     * с заданным value в коллекции List<HorizontalLine>
     */
    private int countPointElements(int value, String side) {
        List<HorizontalLine> panel;
        if (side.equalsIgnoreCase(MINE)) {
            panel = MinePanelSingleton.instance(null).getPanel();
        } else if (side.equalsIgnoreCase(ENEMY)) {
            panel = EnemyPanelSingleton.instance(null).getPanel();
        } else {
            throw new SideNotFoundException();
        }
        return (int) panel
                .stream()
                .map(HorizontalLine::getPointElementList)
                .flatMap(Collection::stream)
                .filter(pointElement -> pointElement.getValue() == value)
                .count();
    }
}

