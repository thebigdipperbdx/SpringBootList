package com.io.mementopattern;

/**
 * @author yanyugang
 * @description 管理者
 * @date 2019-10-08 16:34
 */
public class Caretaker {
    private Memento memento;

    public void setMemento(Memento m){
        memento=m;
    }

    public Memento getMemento(){
        return memento;
    }
}
