package com.sto.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-09 15:07
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args){
        LinkedBlockingQueue<String> queue=new LinkedBlockingQueue<>(20);
        queue.add("Hello");
        queue.add("World");
        System.out.println(queue.size());
        System.out.println(queue.peek());

        for (String value : queue) {
            System.out.println(value);
        }
    }
}
