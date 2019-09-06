package com.fuzzy.search.util;

/**
 * @author yanyugang
 * @description
 * @date 2019-08-20 11:28
 */
public class TestLock {
    public String concatString(String s1,String s2,String s3){
        return s1+s2+s3;
    }

    public static void main(String[] args){
        char c='c';
        int k=1+c;
        System.out.println(k);
        System.out.println(c);
    }
}
