package com.example.guavaexecise.guava.collect;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.List;

/**
 * @author yanyugang
 * @description
 * 排序器[Ordering]是Guava流畅风格比较器[Comparator]的实现，它可以用来为构建复杂的比较器，以完成集合排序的功能。
 * http://ifeve.com/google-guava-ordering/
 * @date 2019-11-16 16:52
 */
public class OrderingTest {
    /**
     * A B C D E F G
     * H I J K L M N
     * O P Q R S T
     * U V W X Y Z
     */
    public static void main(String[] args){
        // 考虑到排序器应该能处理sortedBy为null的情况，我们可以使用下面的链式调用来合成排序器
        // 按自然排序、null放前面、按sortedBy字段排序
        Ordering<Foo> ordering=Ordering.natural().nullsFirst().onResultOf(foo -> foo.sortedBy);

        List<Foo> list=Lists.newArrayList();
        list.add(Foo.builder().sortedBy(null).notSortedBy(1).build());
        list.add(Foo.builder().sortedBy("name").notSortedBy(2).build());
        list.add(Foo.builder().sortedBy(null).notSortedBy(3).build());
        list.add(Foo.builder().sortedBy("age").notSortedBy(4).build());
        list.add(Foo.builder().sortedBy("sex").notSortedBy(5).build());
        System.out.println(list.toString());
        Collections.sort(list,ordering);
        System.out.println(list.toString());

    }

    /**
     * [Foo(sortedBy=null, notSortedBy=1), Foo(sortedBy=name, notSortedBy=2), Foo(sortedBy=null, notSortedBy=3), Foo(sortedBy=age, notSortedBy=4), Foo(sortedBy=sex, notSortedBy=5)]
     * [Foo(sortedBy=null, notSortedBy=1), Foo(sortedBy=null, notSortedBy=3), Foo(sortedBy=age, notSortedBy=4), Foo(sortedBy=name, notSortedBy=2), Foo(sortedBy=sex, notSortedBy=5)]
     */
}
