package com.io.mementopattern;

/**
 * @author yanyugang
 * @description 备忘录
 * @date 2019-10-08 16:32
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state=state;
    }

    public void setState(String state){
        this.state=state;
    }

    public String getState(){
        return state;
    }
}
