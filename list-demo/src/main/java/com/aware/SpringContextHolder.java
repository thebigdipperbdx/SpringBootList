package com.aware;


import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author yanyugang
 * @description 以静态变量保存Spring ApplicationContext， 可在任何代码任何处所任何时辰中取出ApplicaitonContext
 * 表示spring启动时，立刻进行实例化。
 * @date 2019-09-29 10:30
 */
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的context注入函数， 将其存入静态变量.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        SpringContextHolder.applicationContext=applicationContext;

    }

    /**
     * 从静态变量ApplicationContext中取得Bean， 主动转型为所赋值对象的类型
     * org.springframework.beans.factory.BeanFactory.getBean(String)
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name){
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean， 主动转型为所赋值对象的类型. 若是有多个Bean合适Class， 取出第一个.
     * org.springframework.beans.factory.BeanFactory.getBean(Class<T>)
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz){
        checkApplicationContext();
        Map beanMaps=applicationContext.getBeansOfType(clazz);
        if (beanMaps!=null && !beanMaps.isEmpty()){
            return (T) beanMaps.values().iterator().next();
        }else {
            return null;
        }
    }

    private static void checkApplicationContext(){
        if (applicationContext==null){
            throw new IllegalStateException("applicaitonContext未注入，请在applicationContext.xml中定义SpringContextHolder");
        }
    }
}