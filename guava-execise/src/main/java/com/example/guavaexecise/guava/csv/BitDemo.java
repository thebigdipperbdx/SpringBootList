package com.example.guavaexecise.guava.csv;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-12-02 15:34
 */
public class BitDemo {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str);
        // 16进制
        int bitmask = 0x000F;
        System.out.println(bitmask);
        int val = 0x2222;
        System.out.println(val);
        // prints "2"
        System.out.println(val & bitmask);
       // Ternary (shorthand for if-then-else statement)
        int result = (bitmask > val) ? 0 : 1;
        System.out.println(result);
    }
}
