package edu.javagroup.seabattle.singleton;

/**
 * Синглтон ImReadySingleton
 *
 * хранит состояние готовности к игре игрока
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class ImReadySingleton {
    private static volatile ImReadySingleton instance;
    private final Boolean ready;

    private ImReadySingleton(Boolean ready) {
        this.ready = ready;
    }

    public static ImReadySingleton instance(Boolean ready) {
        if (instance == null) {
            instance = new ImReadySingleton(true);
        }
        if (ready != null) {
            instance = new ImReadySingleton(ready);
        }
        return instance;

    }


    public Boolean imReady() {
        return ready;
    }

}
