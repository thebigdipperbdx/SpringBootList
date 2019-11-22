package com.sto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-18 19:34
 */
@Component
@Order(value = 3) // 决定各个Runner的执行次序
public class MyCommandLineRunner3 implements CommandLineRunner {
    /**
     * SpringBoot启动执行的任务方法
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception{
        System.out.println("33333");
    }
}
