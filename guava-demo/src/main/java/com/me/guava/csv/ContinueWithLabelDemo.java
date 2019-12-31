package com.me.guava.csv;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-12-14 15:38
 */
public class ContinueWithLabelDemo {
    public static void main(String[] args) {

        int x = 3;

        // invoke passMethod() with
        // x as argument
        passMethod(x);

        // print x to see if its
        // value has changed
        System.out.println("After invoking passMethod, x = " + x);

    }

    // change parameter in passMethod()
    public static void passMethod(int p) {
        p = 10;
    }


}
