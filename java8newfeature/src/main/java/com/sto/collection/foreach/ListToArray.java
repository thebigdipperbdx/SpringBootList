package com.sto.collection.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {
    //集合转化为数组
    public void testList2Array(){

        // 构建一个集合
        List<String> list=new ArrayList<>();
        list.add("Calligraphy is the art of beautiful handwriting.");
        list.add("He really takes good care of his sister.What a thoughtful boy!");
        list.add("Working hard in the gymnasium keeps us fit.");

        // 转为数组
        String[] strings=list.toArray(new String[list.size()]);

        // 遍历
        Arrays.stream(strings).forEach(System.out::println);
    }

    //数组转化为集合，并尝试添加
    public void array2ListAttemptAdd(){
        String[] arr=new String[]{"Calligraphy is the art of beautiful handwriting."
                , "He really takes good care of his sister.What a thoughtful boy!"
                , "Working hard in the gymnasium keeps us fit."};

        // 转为集合
        List<String> list=Arrays.asList(arr);

        try {
            //会报java.lang.UnsupportedOperationException
            list.add("When it gets cold, I sleep with a thick quilt to stay warm.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 遍历
        list.forEach(n -> System.out.println(n));
    }


    //1. 数组转化为集合
    //2. 并将该结果集合转化为java.util.ArrayList【严格规范的做法】
    //3. 然后尝试添加
    public void array2ArrayListAndAdd(){
        String[] arr=new String[]{"Calligraphy is the art of beautiful handwriting."
                , "He really takes good care of his sister.What a thoughtful boy!"
                , "Working hard in the gymnasium keeps us fit."};

        // 转为集合
        // 也可以是java.util.LinkedList、java.util.Vector<E>
        List<String> list=new ArrayList<>(Arrays.asList(arr));

        try {
            //正常添加
            list.add("When it gets cold, I sleep with a thick quilt to stay warm.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 遍历
        list.forEach(n -> System.out.println(n));
    }


}
