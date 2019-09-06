package com.sto.util;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019/9/6 20:35
 */
public class SemaphoreTest {
    public static void main(String[] args){
        // 最大同时能接收500个请求
        Semaphore semaphore=new Semaphore(500);
        try {
            if (semaphore.tryAcquire()){
                //业务逻辑处理
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
