package com.io.mementopattern;

/**
 * @author yanyugang
 * @description 发起人
 * @date 2019-10-08 16:31
 */
public class Originator {
    private String state;

    public void setState(String state){
        this.state=state;
    }

    public String getState(){
        return state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void restoreMemento(Memento m){
        this.setState(m.getState());
    }
}
