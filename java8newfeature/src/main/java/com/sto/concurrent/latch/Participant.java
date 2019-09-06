package com.sto.concurrent.latch;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name){
        this.conference=conference;
        this.name=name;

    }

    @Override
    public void run(){

        long duration=(long) (Math.random() * 10);
        try {
            System.out.println(Thread.currentThread().getName() + " is running");
            TimeUnit.SECONDS.sleep(duration);

            conference.arrive(name);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}