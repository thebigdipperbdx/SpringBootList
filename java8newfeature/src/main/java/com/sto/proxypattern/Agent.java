package com.sto.proxypattern;

/**
 * @author yanyugang
 * @description 静态代理
 * @date 2019-09-21 10:31
 */
public class Agent implements Person {
    private Actor actor;
    private String before;
    private String after;

    public Agent(Actor actor, String before, String after){
        this.actor=actor;
        this.before=before;
        this.after=after;
    }

    @Override
    public void speak(){
        //before speak
        System.out.println("Before actor speak, Agent say: " + before);
        //real speak
        this.actor.speak();
        //after speak
        System.out.println("After actor speak, Agent say: " + after);
    }
}
