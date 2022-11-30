package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelValue;
import lombok.Getter;

/**
 * Класс PointElement потомок класса ModelValue и имплементация интерфейса Comparable<>,
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
@Getter
public class PointElement extends ModelValue implements Comparable<PointElement> {
    private final Integer col;

    /**
     * Конструктор PointElement
     * инициализирует поля
     * private final Integer col
     * и value суперкласса
     */
    public PointElement(Integer col, int value) {
        super(value);
        this.col = col;
    }

    /**
     * переопределенный метод compareTo интерфейса Comparable<>
     * сортирует обыекты данного класса по полю col
     */
    @Override
    public int compareTo(PointElement obj) {
        return getCol().compareTo(obj.getCol());
    }

}


