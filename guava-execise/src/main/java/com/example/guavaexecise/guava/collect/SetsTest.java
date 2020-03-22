package com.example.guavaexecise.guava.collect;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yanyugang
 * @description
 * Static utility methods pertaining to {@link Set} instances.
 * @date 2019-11-09 15:01
 */
public class SetsTest {
    public static void main(String[] args){
        coreFunList();
    }

    // Sets主要方法
    public static void coreFunList(){
        System.out.println("---------字符串转集合--------------");
        HashSet<String> set1=Sets.newHashSet("1","8");
        set1.forEach(n -> System.out.print(n + " "));
        System.out.println();
        HashSet<String> set2=Sets.newHashSet("1","2");
        set2.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("---------set1和set2并集--------------");
        Sets.SetView<String> union=Sets.union(set1, set2);
        union.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("---------set1和set2交集--------------");
        Sets.SetView<String> intersection=Sets.intersection(set1, set2);
        intersection.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("---------set1和set2差集--------------");
        //差集 1中有而2中没有的
        Sets.SetView<String> difference=Sets.difference(set1, set2);
        difference.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("---------set1和set2相对差集--------------");
        //相对差集 1中有2中没有  2中有1中没有的 取出来做结果
        Sets.SetView<String> symmetricDifference=Sets.symmetricDifference(set1, set2);
        symmetricDifference.forEach(n -> System.out.print(n + " "));
        System.out.println();

    }
}
