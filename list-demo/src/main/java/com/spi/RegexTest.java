package com.spi;

import com.alibaba.fastjson.JSON;

/**
 * @author yanyugang
 * @description 正则表达式校验
 * @date 2019-10-31 13:34
 */
public class RegexTest {

    public static void main(String[] args) {
        String str = "{\"age\":\"12\"}";
        MyDto parse = (MyDto) JSON.parseObject(str, MyDto.class);
        System.out.println(parse.getAge());

        //测试 Java 正则表达式
        String regex = "^(33).*|(37).*|(773).*";
        String billNo = "3300000000000";
        boolean flag = billNo.matches(regex);
        System.out.println(flag);

    }
}
