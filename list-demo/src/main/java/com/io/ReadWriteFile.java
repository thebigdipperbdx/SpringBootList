package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/**
 * @author yanyugang
 * @description 文件读写例子
 * @date 2019-10-14 9:36
 */
public class ReadWriteFile {
    private static final String path="D:/readwritefile.txt";

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

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }

        try (BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file, true))) {
            // 父级目录存在的情况下，文件才能创建成功
            bos.write(buf.toString().getBytes(Charset.defaultCharset()));
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readFileFun(){
        //待读取的内容
        try (BufferedInputStream bis=new BufferedInputStream(new FileInputStream(new File(path)))) {
            byte[] buf=new byte[1024];
            int len=0;
            System.out.println("------------------读取内容--------------------------");
            while ((len=bis.read(buf))!=-1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
