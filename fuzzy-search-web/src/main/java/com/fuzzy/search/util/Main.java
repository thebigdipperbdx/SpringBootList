package com.fuzzy.search.util;

/**
 * @author yanyugang
 * @description
 * @date 2019-08-19 15:54
 */
public class Main {
    public static void main(String[] args){
        String msg="timeout";
        if (msg.indexOf("timeout")!=-1){
            msg="查询超时，请稍后重试！";
        }
        System.out.println(msg);
    }
}
