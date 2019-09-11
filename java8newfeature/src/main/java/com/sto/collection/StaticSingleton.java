package com.sto.collection;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019/9/8 21:02
 */
public class StaticSingleton {
    private static class SingletonHolder {
        private static final StaticSingleton instance= new StaticSingleton();
    }

    private StaticSingleton (){}
    public static final StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
