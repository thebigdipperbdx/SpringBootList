package com.sto.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-09 14:40
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args){
        // 先进先出（FIFO—first in first out）
        ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(10);
        queue.add("Hello");
        queue.add("World");
        System.out.println(queue.size());
        System.out.println(queue.peek());

        for (String value : queue) {
            System.out.println(value);
        }
    }
}
