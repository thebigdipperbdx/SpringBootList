package com.sto.csv;

import java.lang.reflect.Proxy;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-21 14:42
 */
public class SimpleAOP {
    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(), advice);
    }
}
