package com.example.guavaexecise.guava.collect;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyugang
 * @description
 * Static utility methods pertaining to {@link List} instances.
 * @date 2019-11-09 11:44
 */
public class ListsTest {
    public static void main(String[] args){
        coreFunList();
    }

    // Lists主要方法
    public static void coreFunList(){
        System.out.println("---------字符串转集合--------------");
        String str="10010";
        ArrayList<String> list=Lists.newArrayList(str);
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("----------数组转集合-------------");
        String[] array={"1", "2", "3", "4"};
        ArrayList<String> strings=Lists.newArrayList(array);
        strings.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("----------数组反转-------------");
        List<String> reverse=Lists.reverse(strings);
        reverse.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("----------添加新元素-------------");
        //return an unmodifiable list containing the specified elements
        List<String> addList=Lists.asList("0", array);
        addList.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("----------获取子集合-------------");
        //a list of consecutive sublists
        List<List<String>> partition=Lists.partition(addList, 2);
        partition.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
