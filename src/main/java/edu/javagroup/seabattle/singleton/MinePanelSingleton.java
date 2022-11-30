package edu.javagroup.seabattle.singleton;

import edu.javagroup.seabattle.model.HorizontalLine;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Синглтон MinePanelSingleton
 *
 * хранит состояние игрового поля игрока
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class MinePanelSingleton {
    private static volatile MinePanelSingleton instance;
    @Getter
    private final List<HorizontalLine> panel;

    public MinePanelSingleton(List<HorizontalLine> panel) {
        this.panel = panel;
    }

    public static MinePanelSingleton instance(List<HorizontalLine> panel) {
        if (instance == null) {
            instance = new MinePanelSingleton(new ArrayList<>(0));
        }
        if (panel != null) {
            Collections.sort(panel);
            instance = new MinePanelSingleton(panel);
        }


        return instance;
    }

}
