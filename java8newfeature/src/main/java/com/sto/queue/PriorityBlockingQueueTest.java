package com.sto.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author yanyugang
 * @description
 * @date 2019-10-10 11:26
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args){
        PriorityBlockingQueue priorityBlockingQueue=new PriorityBlockingQueue();
        priorityBlockingQueue.add("Hello");
        priorityBlockingQueue.add("World");
        priorityBlockingQueue.add("Hello");
        priorityBlockingQueue.add("Java");

    }
}
