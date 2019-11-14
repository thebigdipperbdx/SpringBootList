package com.me.guava.jdk;

import javax.annotation.Resource;
import java.util.function.Predicate;

/**
 * @author yanyugang
 * @description
 * 函数式接口 java.util.function.Predicate
 * @date 2019-11-10 13:35
 */
public class PredicateTest {
    public static void main(String[] args) {
        /**
         * 1、判断数字是否大于7
         */
        //设置一个大于7的过滤条件
        Predicate<Integer> predicate =x -> x > 7;
        System.out.println(predicate.test(10)); //输出 true
        System.out.println(predicate.test(6));  //输出 fasle
        /**
         * 2、大于7并且
         */
        //在上面大于7的条件下，添加是偶数的条件
        predicate = predicate.and(x -> x % 2 == 0);
        System.out.println(predicate.test(6));  //输出 fasle
        System.out.println(predicate.test(12)); //输出 true
        System.out.println(predicate.test(13)); //输出 fasle
        /**
         * 3、add or 简化写法
         */
        predicate = x -> x > 5 && x < 9;
        System.out.println(predicate.test(10)); //输出 false
        System.out.println(predicate.test(6));  //输出 true
    }
}
