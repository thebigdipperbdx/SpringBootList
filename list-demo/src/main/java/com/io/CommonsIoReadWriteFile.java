package com.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author yanyugang
 * @description commons-io实现文件读写例子
 * @date 2019-10-14 9:36
 */
public class CommonsIoReadWriteFile {
    private static final String path="D:/day22/commonsioreadwritefile.txt";

    public static void main(String[] args){
        // 写文件
        writeFileFun();
        // 读文件
        readFileFun();

    }

    private static void writeFileFun(){
        //待写入的内容
        StringBuffer buf=new StringBuffer();
        buf.append("Hello World!").append("\r\n");
        buf.append("你好，世界！").append("\r\n");
        buf.append("Hello Java!").append("\r\n");
        buf.append("你好，Java！").append("\r\n");
        try {
            FileUtils.writeStringToFile(new File(path), buf.toString(), "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileFun(){
        //待读取的内容
        System.out.println("------------------读取内容--------------------------");
        try {
            System.out.println(FileUtils.readFileToString(new File(path), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
