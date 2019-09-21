package com.sto.proxypattern;

/**
 * @author yanyugang
 * @description 动态代理
 * @date 2019-09-21 10:36
 */
public class Apple implements Fruit{
    @Override
    public void show() {
        System.out.println("<<<<show method is invoked");
    }
}
