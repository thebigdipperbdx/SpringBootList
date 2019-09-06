package com.fuzzy.search.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author yanyugang
 * @description 实现BeanNameAware接口，BeanFactoryAware接口
 * @date 2019/8/18 21:13
 */
@Component
public class HelloBean implements BeanNameAware, BeanFactoryAware, BeanPostProcessor {
    private BeanFactory beanFactory;

    // 获取IOC容器中定义的自身bean的ID
    @Override
    public void setBeanName(String s){
        System.out.println("回调setBeanName方法，id属性是" + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException{
        System.out.println("beanFactory=====>" + beanFactory);
        this.beanFactory=beanFactory;
    }

    // 获取Bean的工厂
    public void executeProcess(String beanName){
        SayBean sayBean=(SayBean) beanFactory.getBean(beanName);
        sayBean.say();
    }

    // 该方法主要针对spring在bean初始化时调用初始化方法前进行自定义处理
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        // 可以运用 instanceof 对指定的Bean进行自定义处理
        System.out.println("BeanPostProcessor的前置处理，beanName====>" + beanName);
        return bean;
    }

    // 该方法主要针对spring在bean初始化时调用初始化方法后进行自定义处理
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        System.out.println("BeanPostProcessor的后置处理，beanName====>" + beanName);
        return bean;
    }
}