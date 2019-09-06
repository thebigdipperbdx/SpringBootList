package com.sto.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

    private final CountDownLatch controller;

    public VideoConference(int number){
        controller=new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.println(name + " has arrived.");
        controller.countDown();
        System.out.println("VideoConference:Waiting for " + controller.getCount());
    }

    @Override
    public void run(){

        System.out.println("VideoConference:Initialization:" + controller.getCount());

        try {
            controller.await();

            //等待10个任务执行完成，开始执行自己的业务逻辑
            System.out.println("-----------------------------------------------");
            System.out.printf("VideoConference: All the participants have finished!\n");
            System.out.printf("VideoConference: Let's start...\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
} 