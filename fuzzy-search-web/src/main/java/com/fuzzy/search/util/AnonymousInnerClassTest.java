package com.fuzzy.search.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author yanyugang
 * @description 匿名内部类的用法
 * @date 2019-08-15 15:28
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args){
        Gson gson=new Gson();

        String str="{ \"mailNo\": \"12345678\",\"orgCode\": \"315005\"}";
        // 单个对象
        NameReq nameReq = gson.fromJson(str, NameReq.class);

        String strList="[{ \"mailNo\": \"12345678\",\"orgCode\": \"315005\"},{ \"mailNo\": \"12345678\",\"orgCode\": \"315005\"}]";
        // 集合对象
        List<NameReq> nameReqList=gson.fromJson(strList,new TypeToken<List<NameReq>>(){}.getType());

        /**
         * 定义了一个继承TypeToken的匿名内部类
         */
        Type type=new TypeToken<List<NameReq>>() {}.getType();
    }
}
