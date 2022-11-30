package edu.javagroup.seabattle.singleton;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Синглтон ShipStorageSingleton
 *
 * хранит информацию о количестве кораблей
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class ShipStorageSingleton {
    private static volatile ShipStorageSingleton instance;
    @Getter
    private final Map<String, Integer> shipMap;

    private ShipStorageSingleton(Map<String, Integer> shipMap) {
        this.shipMap = shipMap;
    }


    public static ShipStorageSingleton instance(Map<String, Integer> shipMap) {
        if (instance == null) {
            instance = new ShipStorageSingleton(new HashMap<>(0));
        }
        if (shipMap != null) {
            instance = new ShipStorageSingleton(shipMap);
        }
        return instance;
    }


}
