package com.sto.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-20 15:19
 */
public class DivideByPageTest {
    public static void main(String[] args){
        //判断数据量，数据量较大时分步插入
        List<Object> carInfoList=new ArrayList<>();
        for(int i=0;i<=100;i++){
            carInfoList.add(i+1);
        }
        int totalSize=carInfoList.size();
        int pageSize=10;
        Map parameter=new HashMap();
        if (totalSize <= pageSize){
            parameter.put("carInfoList", carInfoList);
            List<Object> list=carInfoList;
        }else {
            // 总页数
            int pages=(totalSize % pageSize==0) ? totalSize / pageSize : totalSize / pageSize + 1;
            for (int i=0; i < pages; i++) {
                parameter.put("carInfoList", carInfoList.subList(i * pageSize, Math.min((i + 1) * pageSize, carInfoList.size())));
                List<Object> list=new ArrayList<>(carInfoList.subList(i * pageSize, Math.min((i + 1) * pageSize, carInfoList.size())));
                System.out.println(Arrays.toString(list.toArray()));
            }
        }
    }
}
