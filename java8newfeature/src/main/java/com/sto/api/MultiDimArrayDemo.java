package com.sto.api;

/**
 * @author yanyugang
 * @description 二维数组
 * @date 2019-12-11 16:29
 */
public class MultiDimArrayDemo {
    public static void main(String[] args) {
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);
    }
}
