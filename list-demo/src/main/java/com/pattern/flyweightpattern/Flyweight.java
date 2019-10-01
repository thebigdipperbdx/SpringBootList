package com.pattern.flyweightpattern;

/**
 * @author yanyugang
 * @description 抽象享元角色
 * @date 2019-09-30 13:53
 */
public interface Flyweight {
    void operation(UnsharedConcreteFlyweight state);
}
