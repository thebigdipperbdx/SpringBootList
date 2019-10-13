package com.io.flyweightpattern;

import java.util.HashMap;

/**
 * @author yanyugang
 * @description 享元工厂角色
 * @date 2019-09-30 13:57
 */
public class FlyweightFactory {
    // 用 HashMap 存储这些对象
    private HashMap<String, Flyweight> flyweights=new HashMap<>();

    public Flyweight getFlyweight(String key){
        Flyweight flyweight=(Flyweight) flyweights.get(key);
        if (flyweight!=null){
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        }else {
            flyweight=new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}
