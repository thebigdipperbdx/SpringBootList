package com.sto.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-09 13:57
 */
public class AtomicIntegerTest {
    public static void main(String[] args){
        AtomicInteger num=new AtomicInteger(10);
        System.out.println("AtomicInteger当前值====>" + num.get());
        System.out.println("设置新值，返回旧值====>" + num.getAndSet(20));
        System.out.println("AtomicInteger当前值====>" + num.get());
        // 加5操作
        num.addAndGet(5);
        System.out.println("AtomicInteger当前值====>" + num.get());
        // 加5操作
        num.getAndAdd(5);
        System.out.println("AtomicInteger当前值====>" + num.get());
    }
}
