package com.fuzzy.search.concurrent;

/**
 * @author yanyugang
 * @description DCL单例模式
 * @date 2019-08-06 13:32
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class) {
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args){
        Singleton.getInstance();
    }
}