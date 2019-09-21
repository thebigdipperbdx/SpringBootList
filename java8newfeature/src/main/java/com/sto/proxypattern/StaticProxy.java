package com.sto.proxypattern;

/**
 * @author yanyugang
 * @description 静态代理
 * @date 2019-09-21 10:32
 */
public class StaticProxy {
    public static void main(String[] args){
        Actor actor=new Actor("I am a famous actor!");
        Agent agent=new Agent(actor, "Hello I am an agent.", "That's all!");
        agent.speak();
    }
}
