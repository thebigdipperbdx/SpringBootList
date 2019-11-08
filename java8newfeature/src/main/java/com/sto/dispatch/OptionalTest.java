package com.sto.dispatch;

import java.util.Optional;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-07 11:40
 */
public class OptionalTest {
    public static void main(String[] args){
        Optional<String> optional=Optional.of("Hello World");
        System.out.println(optional.toString());
        Optional<String> hello_world=Optional.of("Hello World");
        String world=Optional.of("Hello World").get();
    }
}
