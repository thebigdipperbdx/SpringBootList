package com.sto.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yanyugang
 * @description
 * 定期执行线程池（Scheduled线程池）
 * 1、第一次执行任务延迟initialDelay
 * 2、从第二次执行任务开始，每隔period执行一次
 * 3、若任务执行时间t>period，则任务每隔t执行一次
 * 4、设置定时方法：scheduleAtFixedRate(Runnable command, long initialDelay,long period,TimeUnit unit)
 * @date 2019-11-16 10:02
 */
public class ExecutorsTest {
  static   ThreadLocal<SimpleDateFormat> threadLocal=new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


    private static ScheduledExecutorService pool=Executors.newScheduledThreadPool(8, new ThreadFactory() {
        private AtomicInteger count=new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r){
            Thread thread=new Thread(r);
            thread.setName("test-Thread-" + count.incrementAndGet());
            System.out.println(thread.getName());
            return thread;
        }
    });

    public static void main(String[] args){
        AtomicReference<String> format=new AtomicReference<>(threadLocal.get().format(new Date()));
        System.out.println(format.get());
        pool.scheduleAtFixedRate(() -> {
            try {
                // 模拟任务执行时间
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------------");
            format.set(threadLocal.get().format(new Date()));
            System.out.println(format.get());
        }, 5, 10, TimeUnit.SECONDS);
    }
}
