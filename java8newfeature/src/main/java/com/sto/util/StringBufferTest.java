package com.sto.util;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019/9/6 20:18
 */
public class StringBufferTest {
    private static final StringBuffer buffer=new StringBuffer();
    public static void main(String[] args) {
        buffer.append("Hello");
        buffer.append("World");
        buffer.append("Hello");
        buffer.append("Java");
        System.out.println(buffer.toString());
        // 清空
        buffer.setLength(0);
        System.out.println(buffer.toString());
    }
}
