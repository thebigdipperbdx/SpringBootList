package com.sto.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-19 14:00
 */
public class AtomicLongTest {
    public static void main(String[] args){
        AtomicLong num=new AtomicLong(10);
        System.out.println("AtomicLong num当前值==>"+num.get());
        num.incrementAndGet();
        System.out.println("AtomicLong num当前值==>"+num.get());
        num.addAndGet(1);
        System.out.println("AtomicLong num当前值==>"+num.get());
        num.addAndGet(5);
        System.out.println("AtomicLong num当前值==>"+num.get());
    }
}
