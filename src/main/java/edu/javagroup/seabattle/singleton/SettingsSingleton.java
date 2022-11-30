package edu.javagroup.seabattle.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Синглтон SettingsSingleton
 *
 * хранит  информацию сети
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class SettingsSingleton {
    private static volatile SettingsSingleton instance;
    private final Map<String, String> settingsMap;


    private SettingsSingleton(Map<String, String> settingsMap) {
        this.settingsMap = settingsMap;
    }

    public static SettingsSingleton instance(Map<String, String> settingsMap) {
        if (instance == null) {
            instance = new SettingsSingleton(new HashMap<>(0));
        }
        if (settingsMap != null) {
            instance = new SettingsSingleton(settingsMap);
        }
        return instance;
    }

    public String getSettingsByKey(String key) {
        return settingsMap.get(key);
    }

    public Map<String, String> getSettingsMap() {
        return settingsMap;
    }
}
