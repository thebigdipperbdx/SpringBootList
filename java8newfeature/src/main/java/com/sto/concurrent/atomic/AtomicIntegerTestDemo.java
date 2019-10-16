package com.sto.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yanyugang
 * @description AtomicInteger的使用
 * @date 2019/9/7 11:34
 */
public class AtomicIntegerTestDemo {
    private static final AtomicInteger num = new AtomicInteger(0);
    // 设置200条订单生成一个文件
    private static final AtomicInteger total = new AtomicInteger(2);

    public static void main(String[] args) {
        // 比较相等
        if (num.get() == total.get()) {
            System.out.println("equal");
        }
        // 加一
        num.addAndGet(1);
        // 加一
        num.addAndGet(1);
        System.out.println(num);
        System.out.println(total);
        if (num.get() == total.get()) {
            System.out.println("equal");
        }
        // 置0
        num.getAndSet(0);
        total.getAndSet(0);
        System.out.println(num);
        System.out.println(total);
    }
}
