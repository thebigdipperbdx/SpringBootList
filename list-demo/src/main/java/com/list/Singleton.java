package com.list;

/**
 * @author yanyugang
 * @description 双重校验锁（DCL）
 * @date 2019-10-10 9:06
 */
public class Singleton {
    private static volatile Singleton singleton;
    // 防止反射创建对象
    private Singleton (){}
    // 静态方法
    public static Singleton getInstance() {
        if (singleton == null) {
            // 对当前类加锁
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
