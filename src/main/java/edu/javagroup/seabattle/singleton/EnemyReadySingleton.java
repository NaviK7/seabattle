package edu.javagroup.seabattle.singleton;

/**
 * Синглтон EnemyReadySingleton
 *
 * хранит состояние готовности к игре противника
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class EnemyReadySingleton {
    private static volatile EnemyReadySingleton instance;
    private final Boolean enemyReady;

    public EnemyReadySingleton(Boolean enemyReady) {
        this.enemyReady = enemyReady;
    }

    public static EnemyReadySingleton instance(Boolean enemyReady) {
        if (instance == null) {
            instance = new EnemyReadySingleton(false);
        }
        if (enemyReady != null) {
            instance = new EnemyReadySingleton(enemyReady);
        }
        return instance;
    }

    public Boolean enemyReady() {
        return enemyReady;
    }
}
