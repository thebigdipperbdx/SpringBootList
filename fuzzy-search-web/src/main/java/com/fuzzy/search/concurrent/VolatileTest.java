package com.fuzzy.search.concurrent;

/**
 * @author yanyugang
 * @description VolatileTest
 * @date 2019-08-06 10:35
 */
public class VolatileTest {
    public static volatile int race=0;

    public static void increase(){
        race++;
    }

    private static final int THREADS_COUNT=20;

    public static void main(String[] args){
        Thread[] threads=new Thread[THREADS_COUNT];
        for (int i=0; i < THREADS_COUNT; i++) {
            threads[i]=new Thread(() -> {
                for (int i1=0; i1 < 10000; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
            System.out.println(race);
        }
    }
}
