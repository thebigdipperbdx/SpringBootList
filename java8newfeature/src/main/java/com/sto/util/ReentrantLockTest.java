package com.sto.util;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanyugang
 * @description ReentrantLock是可以重入的锁, 当一个线程获取锁时, 还可以接着重复获取多次
 * ReentrantLock和synchronized都是独占锁,只允许线程互斥的访问临界区
 * @date 2019-09-06 17:21
 */
public class ReentrantLockTest {
    public static void main(String[] args){
        ReentrantLock lock=new ReentrantLock();
        try {
            if (lock.tryLock()){
                //业务逻辑处理
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
