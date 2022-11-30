package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.exception.SideNotFoundException;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.service.PanelService;
import edu.javagroup.seabattle.service.PointService;
import edu.javagroup.seabattle.singleton.EnemyPanelSingleton;
import edu.javagroup.seabattle.singleton.ForbiddenCellsSingleton;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import edu.javagroup.seabattle.singleton.MyStepSingleton;
import edu.javagroup.seabattle.util.NumberUtils;
import edu.javagroup.seabattle.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;
import java.util.Map;

import static edu.javagroup.seabattle.constants.Constants.ENEMY;
import static edu.javagroup.seabattle.constants.Constants.MINE;

/**
 * Класс PointServiceImpl имплементация интерфейса PointService,
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
@Component
public class PointServiceImpl implements PointService {
    private final PanelService panelService;

    /**
     * Конструктор  инициализирует поле private final PanelService panelService
     */
    public PointServiceImpl(PanelService panelService) {
        this.panelService = panelService;
    }


    /**
     * Метод setShipPoint имплементация интерфейса
     * вызвает метод addShipPoint, если метод isClearPoint вернул true
     * иначе вызывает метод clearShipPoint
     */
    @Override
    public void setShipPoint(char row, int col) {
        if (isClearPoint(row, col)) {
            addShipPoint(row, col);
        } else {
            clearShipPoint(row, col);
        }
    }

    /**
     * имплементация интерфейса PointService
     * метод: setSidePoint
     * проверяет установку кораблей в игровом поле
     */
    @Override
    public boolean setSidePoint(String side, char row, int col, int value) {
        //создаеи переменную коллекцию
        List<HorizontalLine> panel;
        // выбраем нужный singleton MinePanelSingleton или EnemyPanelSingleton
        if (side.equalsIgnoreCase(MINE)) {
            //записываем в переменную коллекцию коллекцию из выбранного синглтона
            panel = MinePanelSingleton.instance(null).getPanel();
        } else if ((side.equalsIgnoreCase(ENEMY))) {
            panel = EnemyPanelSingleton.instance(null).getPanel();
        } else {
            //проброс исключения в случае не правильного указания строны игрока
            throw new SideNotFoundException();
        }
        // итерация колекции из снглтнона с установкой нужного value в нужную ячейку
        for (HorizontalLine i : panel) {
            if (i.getRow() == row) {
                for (PointElement j : i.getPointElementList()) {
                    if (j.getCol() == col) {
                        j.setValue(value);
                        return true;
                    }
                }
            }
        }
        //переопределение коллекции из синглотона
        MinePanelSingleton.instance(panel);
        return false;
    }

    /**
     * имплементация интерфейса PointService
     * метод: isClearPoint
     * вызвает метод isOccupiedCell c value 0
     */
    @Override
    public boolean isClearPoint(char row, int col) {
        return isOccupiedCell(row, col, 0);
    }

    /**
     * имплементация интерфейса PointService
     * метод: getBomb
     * поверка попадания в корабль с запоминанием текущего положения кораблей
     * и в зависимости от этого предачи хода противнику
     */
    @Override
    public boolean getBomb(char row, int col) {
        //если  при вызове метода isOccupiedCell с value 0 или 2 полуается истина то вызваем метод setSidePoint для side - MINE с value - 3
        if (isOccupiedCell(row, col, 0) || isOccupiedCell(row, col, 2)) {
            setSidePoint(MINE, row, col, 3);
            // запись в синглтон MyStepSingleton состояние  шага
            MyStepSingleton.instance(true);
        }
        // если происходит попадание по кораблю то устнавливаем в эту ячейку value ==2
        if (isOccupiedCell(row, col, 1)) {
            // если isOccupiedCell с value 1 возвращает истину, то вызваем setSidePoint для side - MINE с value - 2
            setSidePoint(MINE, row, col, 2);
            //записываем состояние не закончености хода
            MyStepSingleton.instance(false);
            return true;
        }

        return false;
    }

    /**
     * имплементация интерфейса PointService
     * метод: addShipPoint
     * проверка правильности дообавления кораблей в игровое поле
     */
    public void addShipPoint(char row, int col) {
        // если в карте ForbiddenCellsSingleton нет значения true для ключа составленного из параметров метода, то выводим сообщение предупреждение
        if (!ForbiddenCellsSingleton.instance(null).getForbiddenCellsMap().getOrDefault(row + NumberUtils.currentNumber(col), false)) {
            //если не panelService.isFullMinePanel() то выводим сообщение об ошибке
            if (!panelService.isFullMinePanel()) {
                //если setSidePoint для side - MINE и value - 1 то выводим сообщение о запрете использования данной ячейки
                if (setSidePoint(MINE, row, col, 1)) {
                    setForbiddenCells();
                } else {
                    //сообщение запрета использования ячейки
                    JOptionPane.showMessageDialog(null, "Нельзя использовать эту ячейку", "Внимание!", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                // сообщение об ошибке
                JOptionPane.showMessageDialog(null, "Уже занято допустимое количество ячеек", "Внимание!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // сообщение предупреждение
            JOptionPane.showMessageDialog(null, "Не удалось использовать эту ячейку", "Внимание!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * имплементация интерфейса PointService
     * метод: clearShipPoint
     * вызвает метод setSidePoint, где: side - MINE, value - 0
     * вызвает метод setForbiddenCells
     */
    public void clearShipPoint(char row, int col) {
        setSidePoint(MINE, row, col, 0);
        setForbiddenCells();
    }

    /**
     * имплементация интерфейса PointService
     * метод: isOccupiedCell
     * выясняет, занята ли указанная ячейка, указанным значением value
     */
    public boolean isOccupiedCell(char row, int col, int value) {
        return MinePanelSingleton.instance(null).getPanel().stream().filter(i -> i.getRow() == row).
                flatMap(i -> i.getPointElementList().stream()).
                anyMatch(j -> j.getCol() == col && j.getValue() == value);
    }

    /**
     * метод: setForbiddenCells
     * имплементация интерфейса PointService
     * проверка занятости игрового поля целыми кораблями  и запись состояния в карту синглтона
     */
    public void setForbiddenCells() {
        //извлекаем карту из ForbiddenCellsSingleton
        Map<String, Boolean> forbiddenMap = ForbiddenCellsSingleton.instance(null).getForbiddenCellsMap();
        //очистка карты
        forbiddenMap.clear();
        /*  итерируем всю коллекцию и если ячейка занята (value == 1)
         то записываем координаты этой ячейки в карту со значением true
         и запрещаем использование по диагонали ячеек вокруг нее */
        for (HorizontalLine i : MinePanelSingleton.instance(null).getPanel()) {
            for (PointElement j : i.getPointElementList()) {
                if (j.getValue() == 1) {
                    String key0 = i.getRow() + NumberUtils.currentNumber(j.getCol());
                    String key1 = StringUtils.letterBefore(i.getRow()) + NumberUtils.numberBefore(j.getCol());
                    String key2 = StringUtils.letterBefore(i.getRow()) + NumberUtils.numberAfter(j.getCol());
                    String key3 = StringUtils.letterAfter(i.getRow()) + NumberUtils.numberBefore(j.getCol());
                    String key4 = StringUtils.letterAfter(i.getRow()) + NumberUtils.numberAfter(j.getCol());
                    forbiddenMap.put(key0, true);
                    forbiddenMap.put(key1, true);
                    forbiddenMap.put(key2, true);
                    forbiddenMap.put(key3, true);
                    forbiddenMap.put(key4, true);
                }
            }
        }
        //переопределение карты из синглтона
        ForbiddenCellsSingleton.instance(forbiddenMap);
    }

}