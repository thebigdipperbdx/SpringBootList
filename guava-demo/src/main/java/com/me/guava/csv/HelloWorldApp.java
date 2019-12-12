package com.me.guava.csv;

import java.util.Arrays;

/**
 * 第一种，javadoc多行注释
 * The HelloWorldApp class implements an application that
 * simply prints "Hello World!" to standard output.
 */
class HelloWorldApp {
    static char ss;
    /*HelloWorld
    第二种注释
    HelloJava*/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        // Display the string.  第三种注释
        System.out.println("Hello World!");
        char kk = 0;
        char pt='k';
        System.out.println("kk===>"+kk);
        System.out.println("ss===>"+(int)ss);
        System.out.println("pt===>"+pt);
    }
}