package com.sto.api;

import java.util.Arrays;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-12-11 16:47
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));

        System.out.println("===============================");
        char[] copyFrom2 = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo2 = Arrays.copyOfRange(copyFrom2, 2, 9);

        System.out.println(new String(copyTo2));
    }

}
