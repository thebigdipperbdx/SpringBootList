package com.fuzzy.search.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yanyugang
 * @description
 * @date 2019-08-31 8:32
 */
public class ListTest {
    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        list.add("hello");
        list.add("world");

        List<String> myList=new LinkedList<>();
        myList.add("hello");
        myList.add("java");
        myList.get(0);

    }
}
