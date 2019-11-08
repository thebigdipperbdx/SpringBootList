package com.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yanyugang
 * @description
 * @date 2019-10-18 17:40
 */
public class CollectionsTest {
    public static void main(String[] args){
        Integer[] arr={3, 6, 8, 5};
        // Arrays处理数组的工具类
        List<Integer> list=Arrays.asList(arr);
        // Collections处理集合的工具类
        Integer max=Collections.max(list);
        System.out.println(max);

        Double d =null;
        System.out.println(d.toString());

    }
}
