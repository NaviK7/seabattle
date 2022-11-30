package edu.javagroup.seabattle.singleton;



/**
 * Синглтон MyStepSingleton
 *
 * хранит информацию об очередности ходов играющих
 *
 * @author Matveenko Ivan
 * @version 1.0
 */
public class MyStepSingleton {
    private static volatile MyStepSingleton instance;
    private final Boolean myStep;

    public MyStepSingleton(Boolean myStep) {
        this.myStep = myStep;
    }

    public static MyStepSingleton instance(Boolean myStep) {
        if (instance == null) {
            instance = new MyStepSingleton(false);
        }
        if (myStep != null) {
            instance = new MyStepSingleton(myStep);
        }
        return instance;
    }

    public Boolean myStep() {
        return myStep;
    }
}

