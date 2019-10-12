package com.list;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yanyugang
 * @description
 * @date 2019-10-09 14:56
 */
public class TestSingleton {
    public static void main(String[] args) throws InterruptedException{

        final Set<String> set=Collections.synchronizedSet(new HashSet<String>());
        // 自定义线程池
        ExecutorService executor=new ThreadPoolExecutor(100, 500,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i=0; i < 1000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run(){
                    Singleton singleton=Singleton.getInstance();
                    set.add(singleton.toString());
                }
            });
        }
        Thread.sleep(5000);
        System.out.println("一共创建了" + set.size() + "个实例");
        for (String str : set) {
            System.out.println(str);
        }
        executor.shutdown();
    }
}
