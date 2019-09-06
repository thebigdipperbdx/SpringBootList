package com.sto.concurrent.latch;

public class TestCountDownLatchMain {

    public static void main(String[] args) {

        VideoConference conference = new VideoConference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();

        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant" + i);
            Thread t = new Thread(p);
            t.start();
        }
    }

}
