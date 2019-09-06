package com.fuzzy.search.concurrent;

/**
 * @author yanyugang
 * @description volatile的使用场景
 * @date 2019-08-06 13:15
 */
public class VolatileScene {
    volatile boolean shutdownRequested;

    public void shutdown(){
        shutdownRequested=true;
    }

    public void doWork(){
        while (!shutdownRequested) {//do stuff
        }
    }
}
