package com.fuzzy.search.util;

/**
 * @author yanyugang
 * @description
 * @date 2019-08-19 15:54
 */
public class Main{
    public static void main(String[] args){
        Boolean bl=new Boolean(true);
        Boolean tl=new Boolean(false);
        System.out.println("bl===="+bl);
        System.out.println("tl===="+tl);
        bl=tl;
        System.out.println("bl===="+bl);
    }
}
