package com.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author yanyugang
 * @description
 * 1、FileInputStream读取文件内容
 * @date 2019/10/13 10:26
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        // 文件路径
        String path = "D:" + File.separator + "helloworld.txt";
        FileInputStreamReadFile(path);
    }

    public static void FileInputStreamReadFile(String path) {
        // JDK7 try-with-resources 自动释放资源
        try (FileInputStream fis = new FileInputStream(new File(path))) {
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len=fis.read(buf)) != -1) {
                System.out.println(new String(buf,0,len));
            }
        } catch (Exception e) {
        }
    }
}
