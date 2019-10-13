package com.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author yanyugang
 * @description
 * 1、BufferedOutputStream创建文件
 * 2、BufferedOutputStream写入内容，文件末尾，追加方式
 * @date 2019/10/13 15:15
 */
public class BufferedOutputStreamTest {
    public static void main(String[] args) {
        // 文件路径（txt或者xml)
        String path = "D:" + File.separator + "bufferedoutputstream.txt";
        BufferedOutputStreamWirteFile(path);
    }

    private static void BufferedOutputStreamWirteFile(String path) {
        // JDK7 try-with-resources 自动释放资源
        // BufferedOutputStream 有缓冲区，含有字节数组buf，默认大小8192，缓冲区满了，再写入文件1
        try (
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(path), true))) {
            StringBuffer buf = new StringBuffer();
            buf.append("Hello World!").append("\r\n");
            buf.append("Hello Java!").append("\r\n");
            buf.append("Hello Shao Yv!").append("\r\n");
            buf.append("Hello Jing Tianming!").append("\r\n");
            buf.append("Hello Gao Yue!").append("\r\n");
            bos.write(buf.toString().getBytes());
            bos.write(buf.toString().getBytes());
            bos.write(buf.toString().getBytes());
            // 清空缓冲区，写入到文件中
            bos.flush();
        } catch (
                Exception e) {
        }
    }
}
