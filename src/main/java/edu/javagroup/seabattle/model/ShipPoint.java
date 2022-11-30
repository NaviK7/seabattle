package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelValue;
import lombok.Getter;

/**
 * Класс ShipPoint потомок класса ModelValue и имплементация интерфейса Comparable<>,
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
@Getter
public class ShipPoint extends ModelValue implements Comparable<ShipPoint> {
    private final Integer point;

    /**
     * Конструктор ShipPoint
     * инициализирует поля
     * private final Integer point
     * и value суперкласса
     */
    public ShipPoint(Integer point, int value) {
        super(value);
        this.point = point;
    }

    /**
     * переопределенный метод compareTo интерфейса Comparable<>
     * сортирует обыекты данного класса по полю point
     */
    @Override
    public int compareTo(ShipPoint obj) {
        return getPoint().compareTo(obj.getPoint());
    }

}
