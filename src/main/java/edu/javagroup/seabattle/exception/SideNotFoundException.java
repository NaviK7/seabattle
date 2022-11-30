package edu.javagroup.seabattle.exception;

/**
 * Класс-исключение SideNotFoundException наследник класса RuntimeException
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class SideNotFoundException extends RuntimeException {

    /**
     * Конструктор по умолчания SideNotFoundException
     * вызывает message:
     * "Уточните сторону (MINE or ENEMY)"
     */
    public SideNotFoundException() {
        this("Уточните сторону (MINE or ENEMY)");
    }

    /**
     * Конструктор  SideNotFoundException
     * инициализируе вызов сообщения супперкласса
     */
    public SideNotFoundException(String message) {
        super(message);
    }
}
