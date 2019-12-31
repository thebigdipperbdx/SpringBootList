//package com.fuzzy.search.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//
//import java.util.ArrayList;
//
///**
// * @author yanyugang
// * @description ${todo}
// * @date 2019-12-31 9:50
// */
//@Aspect
//@Component
//public class TestAop {
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    public void cutPoint() {
//    }
//
//    @Around("cutPoint()")
//    public Object bizOnPoint(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//
//        for (Object arg:args){
//            System.out.println("Hello World=======>"+arg);
//            if(arg instanceof BindingResult){
//                BindingResult bindingResult = (BindingResult)arg;
//
//            }
//        }
//
//        return joinPoint.proceed();
//    }
//
//
//}
