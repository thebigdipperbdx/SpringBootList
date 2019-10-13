package com.io.flyweightpattern;

/**
 * @author yanyugang
 * @description 非享元角色
 * @date 2019-09-30 13:54
 */
public class UnsharedConcreteFlyweight {
    private String info;

    UnsharedConcreteFlyweight(String info){
        this.info=info;
    }

    public String getInfo(){
        return info;
    }

    public void setInfo(String info){
        this.info=info;
    }
}
