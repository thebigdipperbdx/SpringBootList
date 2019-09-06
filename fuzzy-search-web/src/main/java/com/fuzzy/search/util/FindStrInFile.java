package com.fuzzy.search.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yanyugang
 * @description 查找指定路径下包含给定字符串的文件
 * @date 2019-08-06 14:46
 */
@SuppressWarnings("all")
public class FindStrInFile {
    private static final String UTF_8="utf-8";
    //需要查找的文件类型，可以写多个，以逗号分开
    private static final ArrayList<String> list=new ArrayList<String>() {{
        add(".xml");
        add(".java");
    }};

    //需要查找的文件夹路径
    private final static String filePath="E:\\workspace-full";
    //需要查找的字符串对象
    private final static String STR="insert";

    //全局变量:记录个数
    public static int number=1;

    //在文件中的每行中查找字符串
    public static void searchFileText(File filePath, String str) throws IOException{
        Scanner scan=new Scanner(filePath, UTF_8);
        //记录行数
        int rows=0;
        while (true) {
            if (scan.hasNext()==false){
                //如果没有数据就停止
                break;
            }
            String content=scan.nextLine();
            rows++;
            if (content.toLowerCase().contains(str.toLowerCase())){
                System.out.println();
                String context=number + ".文件:" + filePath.getPath() + " 第" + rows + "行 \n  内容：" + content;
                System.out.println(context);
                System.out.println();
                number++;
            }
        }
    }

    //在文件下所有文件中查找含有字符串的行
    public static void searchFile(File filePath, String str) throws IOException{
        File[] files=filePath.listFiles();
        if (files==null){
            return;
        }
        for (File file : files) {
            //若是文件，直接查找
            if (file.isFile()){
                if (file.getName().endsWith(list.get(0)) || file.getName().endsWith(list.get(1))){
                    searchFileText(file, str);
                }
            }
            //若是目录，则对其目录下的目录或文件继续查找
            if (file.isDirectory()){
                //递归
                searchFile(file, str);
            }
        }
    }

    //启动
    public static void main(String[] args){
        try {
            searchFile(new File(filePath), STR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
