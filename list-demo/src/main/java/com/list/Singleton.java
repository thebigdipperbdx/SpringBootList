package com.list;

/**
 * @author yanyugang
 * @description
 * @date 2019-10-10 9:06
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if (singleton==null){
            // 同步块，给当前对象实例加锁
            synchronized (Singleton.class) {
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
