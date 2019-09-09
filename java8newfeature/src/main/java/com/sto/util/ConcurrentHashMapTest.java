package com.sto.util;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-09 9:18
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args){
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
        map.put("key","value");
    }
}
