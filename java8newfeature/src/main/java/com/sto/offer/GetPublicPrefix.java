package com.sto.offer;

import java.util.Arrays;

/**
 * @author yanyugang
 * @description Leetcode: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * @date 2019-09-20 8:52
 */
public class GetPublicPrefix {
    public static String replaceSpace(String[] strs){
        // 如果检查值不合法及就返回空串
        if (!chechStrFun(strs)){
            return "";
        }
        // 数组长度
        int len=strs.length;
        // 用于保存结果
        StringBuilder res=new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);
        int m=strs[0].length();
        int n=strs[len - 1].length();
        int num=Math.min(m, n);
        for (int i=0; i < num; i++) {
            if (strs[0].charAt(i)==strs[len - 1].charAt(i)){
                res.append(strs[0].charAt(i));
            }else {
                break;
            }

        }
        return res.toString();
    }

    private static boolean chechStrFun(String[] strs){
        boolean flag=false;
        if (strs!=null){
            // 遍历strs检查元素值
            for (int i=0; i < strs.length; i++) {
                if (strs[i]!=null && strs[i].length()!=0){
                    flag=true;
                }else {
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    // 测试
    public static void main(String[] args){
        String[] strs={"customer", "car", "cat"};
        // String[] strs = { "customer", "car", null };//空串
        // String[] strs = {};//空串
        // String[] strs = null;//空串
        System.out.println(GetPublicPrefix.replaceSpace(strs));// c
    }
}
