package edu.javagroup.seabattle.singleton;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


/**
 * Синглтон ForbiddenCellsSingleton
 *
 * хранит карту запрещеных ячеек
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class ForbiddenCellsSingleton {
    private static volatile ForbiddenCellsSingleton instance;
    @Getter
    private final Map<String, Boolean> forbiddenCellsMap;

    private ForbiddenCellsSingleton(Map<String, Boolean> forbiddenCellsMap) {
        this.forbiddenCellsMap = forbiddenCellsMap;
    }

    public static ForbiddenCellsSingleton instance(Map<String, Boolean> forbiddenCellsMap) {
        if (instance == null) {
            instance = new ForbiddenCellsSingleton(new HashMap<>(0));
        }
        if (forbiddenCellsMap != null && forbiddenCellsMap.size() > 0) {
            instance = new ForbiddenCellsSingleton(forbiddenCellsMap);
        }
        return instance;
    }

}
