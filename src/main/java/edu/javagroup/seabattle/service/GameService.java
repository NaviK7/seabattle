package edu.javagroup.seabattle.service;

/**
 * Интерфейс GameService
 * с методами:
 * boolean imReady()
 * boolean enemyReady()
 * void setShipPoint(char row, int col)
 * boolean isFullMinePanel()
 * boolean getBomb(char row, int col)
 * void setSidePoint(String side, char row, int col, int value)
 * boolean checkShipCount()
 * int checkShipCount(int deckCount)
 * int howMuchIsLeft(String side)
 * boolean checkEndGame(String side)
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public interface GameService {
    boolean imReady();

    boolean enemyReady();

    void setShipPoint(char row, int col);

    boolean isFullMinePanel();

    boolean getBomb(char row, int col);

    void setSidePoint(String side, char row, int col, int value);

    boolean checkShipCount();

    int checkShipCount(int deckCount);

    int howMuchIsLeft(String side);

    boolean checkEndGame(String side);
}
