package edu.javagroup.seabattle.service;

/**
 * Интерфейс PointService
 * с методами:
 * void setShipPoint(char row, int col)
 * boolean setSidePoint(String side, char row, int col, int value)
 * boolean isClearPoint(char row, int col)
 * boolean getBomb(char row, int col)
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public interface PointService {
    void setShipPoint(char row, int col);

    boolean setSidePoint(String side, char row, int col, int value);

    boolean isClearPoint(char row, int col);

    boolean getBomb(char row, int col);
}
