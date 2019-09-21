package com.sto.proxypattern;

/**
 * @author yanyugang
 * @description 静态代理
 * @date 2019-09-21 10:29
 */
class Actor implements Person {
    private String content;

    public Actor(String content){
        this.content=content;
    }

    @Override
    public void speak(){
        System.out.println(this.content);
    }
}
