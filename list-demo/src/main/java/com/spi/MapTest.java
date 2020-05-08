package com.spi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(6);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        System.out.println("------------------- map.keySet()-------------------------");
        //获取所有的 key，根据 key 取出对应的value
        for (String key : map.keySet()) {
            System.out.println("key:" + key + ",value:" + map.get(key));
        }

        System.out.println("------------------获取map种所有的value：map.values()--------------------------");
        //遍历所有的value
        for (String value : map.values()) {
            System.out.println("value:" + value);
        }

        System.out.println("-------------------获取键值对：map.entrySet()-------------------------");
        //取出对应的 key，value 键值对,容量大时推荐使用
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("键值对:" + entry);
            //获取 键值对的 key
            System.out.println("key:" + entry.getKey());
            //获取 键值对的 value
            System.out.println("value:" + entry.getValue());
        }

        System.out.println("--------------------- 通过 Map.entrySet使用iterator遍历 key 和 value -----------------------");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        System.out.println("-------------------- map.forEach JDK1.8 新特性 ----------------------");
        map.forEach((key, value) -> {
            System.out.println("key=" + key + ",value=" + value);
        });
    }
}
