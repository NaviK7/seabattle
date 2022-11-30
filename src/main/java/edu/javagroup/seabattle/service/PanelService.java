package edu.javagroup.seabattle.service;

/**
 * Интерфейс PanelService
 * с методами:
 * boolean isPanelEmpty()
 * boolean isFullMinePanel()
 * int howMuchIsLeft(String side)
 * boolean checkEndGame(String side)
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public interface PanelService {
    boolean isPanelEmpty();

    boolean isFullMinePanel();

    int howMuchIsLeft(String side);

    boolean checkEndGame(String side);

}
