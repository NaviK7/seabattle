package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.service.GameService;
import edu.javagroup.seabattle.service.PanelService;
import edu.javagroup.seabattle.service.PointService;
import edu.javagroup.seabattle.service.ShipService;
import edu.javagroup.seabattle.singleton.EnemyReadySingleton;
import edu.javagroup.seabattle.singleton.ForbiddenCellsSingleton;
import edu.javagroup.seabattle.singleton.ImReadySingleton;
import edu.javagroup.seabattle.singleton.SettingsSingleton;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.HashMap;

/**
 * Класс GameServiceImpl имплементация интерфейса GameService,
 *
 * @author Matveenko Ivan, группа Java-21
 * @version 1.0
 */
@Component
public class GameServiceImpl implements GameService {
    private final PanelService panelService;
    private final PointService pointService;
    private final ShipService shipService;



    /**
     * Конструктор  инициализирует поля private final PanelService panelService
     * private final PointService pointService
     * private final ShipService shipService
     */
    public GameServiceImpl(PanelService panelService, PointService pointService, ShipService shipService) {
        this.panelService = panelService;
        this.pointService = pointService;
        this.shipService = shipService;
    }

    /**
     * имплементация интерфейса GameService
     * метод: imReady
     * проверяет готовность игрового поля
     */
    @Override
    public boolean imReady() {
        if (isFullMinePanel()) {
            if (!checkShipCount()) {
                JOptionPane.showMessageDialog(null, "Корабли расставлены неправильно", "Внимание!", JOptionPane.WARNING_MESSAGE);
            } else if (SettingsSingleton.instance(null).getSettingsByKey(Constants.ENEMY_IP_ADDRESS) != null) {
                ImReadySingleton.instance(true);
                ForbiddenCellsSingleton.instance(new HashMap<>(0));
            } else {
                JOptionPane.showMessageDialog(null, "Не указан ip-address врага", "Внимание!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Еще не все корабли расставлены", "Внимание!", JOptionPane.WARNING_MESSAGE);
        }

        return EnemyReadySingleton.instance(null).enemyReady();
    }

    /**
     * Subtask #4
     * имплементация интерфейса GameService
     * метод: enemyReady
     * проверка готовности игрового поля соперника
     */
    @Override
    public boolean enemyReady() {
        EnemyReadySingleton.instance(true);
        boolean imReady = JOptionPane.showConfirmDialog(null, "Клятый враг спрашивает, готов ли ты быть поверженным?", "Окно подтверждения", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
        return imReady() && imReady;
    }

    /**
     * имплементация интерфейса GameService
     * метод: setShipPoin
     * вызвает метод setShipPoint pointService
     */
    @Override
    public void setShipPoint(char row, int col) {
        pointService.setShipPoint(row, col);
    }

    /**
     * имплементация интерфейса GameService
     * метод: isFullMinePanel
     * вызвает метод isFullMinePanel panelService
     */
    @Override
    public boolean isFullMinePanel() {
        return panelService.isFullMinePanel();
    }

    /**
     * имплементация интерфейса GameService
     * метод: getBomb
     * вызвает метод getBomb pointService
     */
    @Override
    public boolean getBomb(char row, int col) {
        return pointService.getBomb(row, col);
    }

    /**
     * имплементация интерфейса GameService
     * метод: setSidePoint
     * вызвает метод setSidePoint pointService
     */
    @Override
    public void setSidePoint(String side, char row, int col, int value) {
        pointService.setSidePoint(side, row, col, value);
    }

    /**
     * имплементация интерфейса GameService
     * метод: checkShipCount
     * вызвает метод checkShipCount shipService
     */
    @Override
    public boolean checkShipCount() {
        return shipService.checkShipCount();
    }

    /**
     * имплементация интерфейса GameService
     * метод: checkShipCount
     * вызвает метод checkShipCount shipService и передает количество палуб
     */
    @Override
    public int checkShipCount(int deckCount) {
        return shipService.checkShipCount(deckCount);
    }

    /**
     * имплементация интерфейса GameService
     * метод: howMuchIsLeft
     * вызвает метод howMuchIsLeft panelService и передает сторону
     */
    @Override
    public int howMuchIsLeft(String side) {
        return panelService.howMuchIsLeft(side);
    }

    /**
     * имплементация интерфейса GameService
     * метод: checkEndGame
     * вызвает метод checkEndGame panelService и передает сторону
     */
    @Override
    public boolean checkEndGame(String side) {
        return panelService.checkEndGame(side);
    }
}
