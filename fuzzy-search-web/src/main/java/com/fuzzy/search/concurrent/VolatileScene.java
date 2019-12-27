package com.fuzzy.search.concurrent;

/**
 * @author yanyugang
 * @description volatile的使用场景
 * 保证可见性、有序性
 * @date 2019-08-06 13:15
 */
public class VolatileScene {
    volatile boolean shutdownRequested;

    public void shutdown(){
        shutdownRequested=true;
    }

    public void doWork(){
        //do stuff
        while (!shutdownRequested) {
        }
    }
}
