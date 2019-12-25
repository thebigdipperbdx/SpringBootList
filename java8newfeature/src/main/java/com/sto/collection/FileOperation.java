package com.sto.collection;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yanyugang
 * @description StringUtils 截取字符串
 * @date 2019-12-13 14:43
 */
public class FileOperation {
    public static String path="D:\\script.txt";

    public static void main(String[] args) throws Exception{
        FileInputStreamReadFile(path);
    }

    public static void FileInputStreamReadFile(String path) throws Exception{
        InputStreamReader inReader=new InputStreamReader(new FileInputStream(new File(path)), "UTF-8");
        BufferedReader br=new BufferedReader(inReader);
        AtomicInteger num=new AtomicInteger(0);

        String contentLine=br.readLine();
        while (contentLine!=null) {

            if (contentLine.contains("values")){
                num.addAndGet(1);
                //values (26
                String prefix=StringUtils.substringBefore(contentLine, ",");
                contentLine=contentLine.replace(prefix, "values (BL_SEQ_CHOICE_CHOICE_ID.nextval");

                String datePre=StringUtils.substringAfter(contentLine, "to_timestamp(");
                String oldChar="to_timestamp(" + datePre;
                String replacement="sysdate, null, null);";
                contentLine=contentLine.replace(oldChar, replacement);
                //System.out.println(datePre);

            }
            System.out.println(contentLine);
            // 读取下一行
            contentLine=br.readLine();
        }
        //System.out.println("num======>"+num);
    }
}
