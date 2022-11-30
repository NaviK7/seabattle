package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelRow;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс HorizontalLine потомок класса ModelRow  и имплементация интерфейса Comparable<>,
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
@Getter
@Setter
public class HorizontalLine extends ModelRow implements Comparable<HorizontalLine> {
    private List<PointElement> pointElementList;

    /**
     * переопределенный метод compareTo интерфейса Comparable<>
     * сортирует обыекты данного класса по полю row
     */
    @Override
    public int compareTo(HorizontalLine obj) {
        return Character.toString(getRow()).compareToIgnoreCase(Character.toString(obj.getRow()));
    }

    /**
     * Конструктор HorizontalLine
     * инициализирует поля
     * private List<PointElement> pointElementList;
     * и row суперкласса
     */
    public HorizontalLine(char row) {
        super(row);
        List<PointElement> list = new ArrayList<>();

        list.add(new PointElement(1, 0));
        list.add(new PointElement(2, 0));
        list.add(new PointElement(3, 0));
        list.add(new PointElement(4, 0));
        list.add(new PointElement(5, 0));
        list.add(new PointElement(6, 0));
        list.add(new PointElement(7, 0));
        list.add(new PointElement(8, 0));
        list.add(new PointElement(9, 0));
        list.add(new PointElement(10, 0));
        pointElementList = list;
    }
}
