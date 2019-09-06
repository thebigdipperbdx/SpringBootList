package com.sto.feature.Lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ThreadDemo {

    public static void main(String[] args){
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        //Java 8方式：
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();


        // Java 8之前：
        JButton show=new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        // Java 8方式：
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }

}
