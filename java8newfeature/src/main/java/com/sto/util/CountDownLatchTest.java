package com.sto.util;

import java.util.concurrent.CountDownLatch;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019/9/6 20:49
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("====begin====");

        // 匿名内部类
        // 当前线程需要等待的线程数
        CountDownLatch countDownLatch = new CountDownLatch(2) {
            @Override
            public void await() throws InterruptedException {
                super.await();
                System.out.println(Thread.currentThread().getName() + " count down is ok");
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                // 释放锁
                countDownLatch.countDown();
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                // 释放锁
                countDownLatch.countDown();
            }
        }, "thread2");

        thread1.start();
        thread2.start();
        // Causes the current thread to wait until the latch has counted down to zero
        countDownLatch.await();
        System.out.println("====end====");
    }
}
