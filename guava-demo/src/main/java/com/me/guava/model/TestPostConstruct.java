package com.me.guava.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author yanyugang
 * @description Spring框架中使用到@PostConstruct注解 该注解的方法在整个Bean初始化中的执行顺序：
 * <p>
 * Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
 * @date 2019-11-22 16:22
 */
@Component
public class TestPostConstruct {
    @Autowired
    private OrderService orderService;

    public TestPostConstruct(){
        System.out.println("TestPostConstruct()=============");
    }

    @PostConstruct
    public void init(){
        System.out.println(orderService);
        System.out.println("init()");
    }


}
