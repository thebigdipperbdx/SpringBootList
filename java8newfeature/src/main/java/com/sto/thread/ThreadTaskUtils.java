package com.sto.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yanyugang
 * @description Spring线程池ThreadPoolTaskExecutor配置及详情
 * 属性字段说明
 * corePoolSize：线程池维护线程的最少数量
 * keepAliveSeconds：允许的空闲时间
 * maxPoolSize：线程池维护线程的最大数量
 * queueCapacity：缓存队列
 * rejectedExecutionHandler：对拒绝task的处理策略
 * @date 2019-11-19 9:25
 */
public class ThreadTaskUtils {
    private static ThreadPoolTaskExecutor taskExecutor=null;

    static{
        taskExecutor=new ThreadPoolTaskExecutor();

        taskExecutor.setCorePoolSize(5);

        taskExecutor.setMaxPoolSize(50);

        taskExecutor.setQueueCapacity(1000);

        taskExecutor.setKeepAliveSeconds(120);

        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        taskExecutor.initialize();
    }

    public static void run(Runnable runnable){
        taskExecutor.execute(runnable);
    }

    public static void main(String[] args){
        for (int i=0; i < 10; i++) {
            final int j=i;
            ThreadTaskUtils.run(new Runnable() {
                @Override
                public void run(){

                    System.out.println("当前执行第：" + j + "页！");
                }
            });
        }

    }

}