package com.me.guava.jdk;

import java.util.Optional;

/**
 * @author yanyugang
 * @description java.util.Optional
 * @date 2019-11-10 10:39
 */
public class OptionalTest {
    public static void main(String[] args){
        String obj="Hello World!";
        // obj为null，会抛出NullPointerException
        Optional<String> optional=Optional.of(obj);
        System.out.println(optional.get());

        // obj为null， returns an empty {@code Optional}
        optional=Optional.ofNullable(obj);
        System.out.println(optional.get());

        // filter 和 orElse 方法
        Integer num=8;
        Integer integer=Optional.of(num).filter(t -> t > 6).orElse(0);
        System.out.println(integer);

        Optional<Integer> possible=Optional.of(5);
        possible.isPresent(); // returns true
        possible.get(); // returns 5

    }
}
