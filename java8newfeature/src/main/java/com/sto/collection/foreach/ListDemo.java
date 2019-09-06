package com.sto.collection.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args){
        List<String> list=new ArrayList<String>();
        list.add("tianming");
        list.add("shaoyu");
        list.add("gaoyue");

        // 方法一，用迭代器迭代
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 方法二，超级for循环遍历
        for (String element : list) {
            System.out.println(element);
        }

        // 方法三，用for循环, 以size为条件遍历:
        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 方法四，Java 8之后，使用lambda表达式对列表进行迭代
        list.forEach(n -> System.out.println(n));

    }

}
