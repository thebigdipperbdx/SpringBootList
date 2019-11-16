package com.sto.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019/9/6 20:49
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        //创建工作等待队列
        BlockingQueue workQueue = new ArrayBlockingQueue(3);
        //创建自定义线程池
        ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(
                2, 4, 100, TimeUnit.SECONDS, workQueue);

        System.out.println("====begin====");

        // 匿名内部类
        // 当前线程需要等待的线程数
        CountDownLatch countDownLatch = new CountDownLatch(6) {
            @Override
            public void await() throws InterruptedException {
                super.await();
                System.out.println(Thread.currentThread().getName() + " count down is ok");
            }
        };


        myThreadPool.execute(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is done");
            // 释放锁
            countDownLatch.countDown();
        });

        myThreadPool.execute(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is done");
            // 释放锁
            countDownLatch.countDown();
        });

        // Causes the current thread to wait until the latch has counted down to zero
        countDownLatch.await();
        System.out.println(countDownLatch.getCount());
        System.out.println("====end====");
    }
}
