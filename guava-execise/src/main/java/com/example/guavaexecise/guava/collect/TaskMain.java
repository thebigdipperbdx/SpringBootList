package com.example.guavaexecise.guava.collect;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-22 14:42
 */
public class TaskMain {
    public static void main(String[] args){
        List<TaskDto> list=Lists.newArrayList();
        list.add(TaskDto.builder().taskNo("83190112256").driverName("李祥东").vehicleLicense("沪AF3405").build());
        list.add(TaskDto.builder().taskNo("83190112255").driverName("李四").vehicleLicense("沪AFS526").build());
        System.out.println(new Gson().toJson(list));


        String str="[{\"taskNo\":\"83190112256\",\"driverName\":\"李祥东\",\"vehicleLicense\":\"沪AF3405\"},{\"taskNo\":\"83190112255\",\"driverName\":\"李四\",\"vehicleLicense\":\"沪AFS526\"}]";
        List<TaskDto> list2=new Gson().fromJson(str,new TypeToken<List<TaskDto>>(){}.getType());
        System.out.println(list2.size());
    }
}
