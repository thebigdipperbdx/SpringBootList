package com.sto.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-19 14:11
 */
public class AtomicIntegerArrayTest {
    public static void main(String[] args){
        // 设置数组大小是5
        AtomicIntegerArray atomicIntegerArray=new AtomicIntegerArray(5);
        System.out.println("AtomicIntegerArray array==>" + atomicIntegerArray.toString());
        // 设置索引为0的元素的值为10
        atomicIntegerArray.set(0, 10);
        System.out.println("AtomicIntegerArray array==>" + atomicIntegerArray.toString());
        // 索引为1的元素加3
        atomicIntegerArray.addAndGet(1, 3);
        System.out.println("AtomicIntegerArray array==>" + atomicIntegerArray.toString());
        // 索引为1的元素加1
        atomicIntegerArray.incrementAndGet(0);
        System.out.println("AtomicIntegerArray array==>" + atomicIntegerArray.toString());


    }
}
