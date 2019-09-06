package com.fuzzy.search.concurrent;

import java.util.Vector;

/**
 * @author yanyugang
 * @description
 * @date 2019-08-08 11:23
 */
public class VectorTest {
    private static Vector<Integer> vector=new Vector<>();

    public static void main(String[] args) throws Exception{
        // 不要同时产生过多的线程，否则会导致操作系统假死
        while (true && Thread.activeCount() <= 200) {
            for (int i=0; i < 100000; i++) {
                vector.add(i);
            }

            Thread removeThread=new Thread(new Runnable() {
                @Override
                public void run(){
                    synchronized (vector){
                        for (int i=0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });
            Thread printThread=new Thread(new Runnable() {
                @Override
                public void run(){
                    synchronized (vector){
                        for (int i=0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });

            System.out.println("Thread.activeCount()====>" + Thread.activeCount());
            removeThread.start();
            printThread.start();
        }

    }
}
