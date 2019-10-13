package com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author yanyugang
 * @description 1、File创建空文件
 * 2、FileOutputStream创建文件
 * 3、FileOutputStream写入内容，文件末尾，追加方式
 * @date 2019/10/13 10:26
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws Exception {
        // 创建一个空文件
        String path2 = "D:" + File.separator + "newfile.txt";
        new File(path2).createNewFile();

        // 文件路径
        String path = "D:" + File.separator + "fileoutputstreamtest.txt";
        OutputStreamWirteFile(path);
    }

    public static void OutputStreamWirteFile(String path) {
        // JDK7 try-with-resources 自动释放资源
        try (OutputStream fos = new FileOutputStream(new File(path), true)) {
            StringBuffer buf = new StringBuffer();
            buf.append("Hello World!").append("\r\n");
            buf.append("Hello Java!").append("\r\n");
            buf.append("Hello Shao Yv!").append("\r\n");
            buf.append("Hello Jing Tianming!").append("\r\n");
            buf.append("Hello Gao Yue!").append("\r\n");
            // 直接写入，FileOutputStream没有缓冲区
            fos.write(buf.toString().getBytes());
            // 直接写入
            fos.write(buf.toString().getBytes());
            // 直接写入
            fos.write(buf.toString().getBytes());
        } catch (Exception e) {
        }
    }
}
