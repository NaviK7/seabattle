package edu.javagroup.seabattle.init;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.singleton.*;

import java.util.*;

/**
 * Класс Initializer
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class Initializer {

    /**
     * метод: init
     * влаживает в SettingsSingleton карту нулевой размерности
     * вызвает метод initPanels
     */
    public void init() {
        SettingsSingleton.instance(new HashMap<>(0));
        initPanels();
    }

    /**
     * метод: initPanels
     * инициализирует игровые поля игроков
     */
    public void initPanels() {
        MyStepSingleton.instance(true);
        ImReadySingleton.instance(false);
        EnemyReadySingleton.instance(false);
        ForbiddenCellsSingleton.instance(new HashMap<>(0));
        //создаем карту desk и инициализируем ее
        Map<String, Integer> desk = new HashMap<>(4);
        desk.put("1" + Constants.DECK, 0);
        desk.put("2" + Constants.DECK, 0);
        desk.put("3" + Constants.DECK, 0);
        desk.put("4" + Constants.DECK, 0);
        //отправляем  карту desk в метод instance
        ShipStorageSingleton.instance(desk);
        //создаем коллекциию List<HorizontalLine> minePanel, инициализируем ее и оправляем в метод instance
        List<HorizontalLine> minePanel = new ArrayList<>();
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            minePanel.add(new HorizontalLine(Constants.VERTICAL_COORDINATE.charAt(i)));
        }
        MinePanelSingleton.instance(minePanel);
        //создаем коллекциию List<HorizontalLine> enemyPanel, инициализируем ее и оправляем в метод instance
        List<HorizontalLine> enemyPanel = new ArrayList<>();
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            enemyPanel.add(new HorizontalLine(Constants.VERTICAL_COORDINATE.charAt(i)));
        }
        EnemyPanelSingleton.instance(enemyPanel);
    }
}

