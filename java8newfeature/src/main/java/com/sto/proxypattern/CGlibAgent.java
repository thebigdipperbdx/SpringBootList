package com.sto.proxypattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yanyugang
 * @description CGlib实现动态代理    CGlib是一个字节码增强库，为AOP等提供了底层支持。
 * 可以看到结果和JDK动态代理是一样的，但是可以直接对实现类进行操作而非接口，这样会有很大的便利。
 * @date 2019-09-21 13:37
 */
public class CGlibAgent implements MethodInterceptor {
    private Object proxy;

    public Object getInstance(Object proxy){
        this.proxy=proxy;
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    //回调方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable{
        System.out.println(">>>>before invoking");
        //真正调用
        Object ret=methodProxy.invokeSuper(o, objects);
        System.out.println(">>>>after invoking");
        return ret;
    }

    public static void main(String[] args){
        CGlibAgent cGlibAgent=new CGlibAgent();
        Apple apple=(Apple) cGlibAgent.getInstance(new Apple());
        apple.show();
    }
}
