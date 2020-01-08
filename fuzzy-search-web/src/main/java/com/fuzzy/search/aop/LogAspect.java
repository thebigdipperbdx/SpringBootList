package com.fuzzy.search.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yanyugang
 * @description 官方配置文档：
 * https://docs.spring.io/spring/docs/5.1.13.BUILD-SNAPSHOT/spring-framework-reference/core.html#aop-ataspectj
 * @date 2019-12-31 9:50
 */
@Aspect
@Component
public class LogAspect {

    // 切点表达式限制为包含指定注解RequestMapping的连接点（配置方式一）
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void cutPoint() {
    }

    @Around("cutPoint()")
    public Object bizOnPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置通知（@Before的作用）");
        Object result = null;
        try {
            // Returns the arguments at this join point.
            // 拦截的方法的参数
            Object[] args = joinPoint.getArgs();
            // 方法的相关信息，方法名等
            Signature signature = joinPoint.getSignature();
            // 方法名
            String name = signature.getName();
            int modifiers = signature.getModifiers();
            long start = System.currentTimeMillis();
            // 执行方法
            result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println(name + "方法执行耗时=====>" + (end - start) + "ms");
            System.out.println("返回通知（@AfterReturning的作用）");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知（@AfterThrowing的作用）");
        } finally {
            System.out.println("后置通知（@After的作用）");
        }
        return result;
    }

    // 切点表达式限制为指定包路径com.fuzzy.search.controller下的任何类的任何方法（配置方式二）
    @Pointcut("execution(* com.fuzzy.search.controller.*.*(..))")
    public void myPoint() {
    }

    @Around("myPoint()")
    public Object bizMyPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("bizMyPoint");
        System.out.println("前置通知（@Before的作用）");
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("返回通知（@AfterReturning的作用）");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知（@AfterThrowing的作用）");
        } finally {
            System.out.println("后置通知（@After的作用）");
        }
        return result;
    }
}
