package com.sto.pattern.prototype;

import java.util.HashMap;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019/9/11 21:39
 */
public class Manager {
    //保存实例的“名字”和“实例”之间的对应关系
    private HashMap<String, Product> showcase = new HashMap<>();

    //register方法将接收到的一组“名字”和“Product接口”注册到showcase中。这里Product是实现Product接口的实例，具体还未确定
    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String productname) {
        Product p = showcase.get(productname);
        return p.createClone();
    }
}
