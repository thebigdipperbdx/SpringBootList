package com.sto.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yanyugang
 * @description
 * 实例说明：实现文件复制功能
 * 实现方式：通道FileChannel、 缓冲区ByteBuffer
 * @date 2019-09-12 15:15
 */
public class NioTest {
    public static void main(String[] args) throws IOException{
        // 设置输入源 & 输出地 = 文件
        String infile="d:/knowledge.txt";
        String outfile="d:/hello.txt";

        // 1. 获取数据源 和 目标传输地的输入输出流（此处以数据源 = 文件为例）
        FileInputStream fin=new FileInputStream(infile);
        FileOutputStream fout=new FileOutputStream(outfile);

        // 2. 获取数据源的输入输出通道
        FileChannel fcin=fin.getChannel();
        FileChannel fcout=fout.getChannel();

        // 3. 创建缓冲区对象
        ByteBuffer buff=ByteBuffer.allocate(1024);

        while (true) {
            // 4. 从通道读取数据 & 写入到缓冲区
            // 注：若 以读取到该通道数据的末尾，则返回-1
            int r=fcin.read(buff);
            if (r==-1){
                break;
            }
            // 5. 传出数据准备：调用flip()方法
            buff.flip();

            // 6. 从 Buffer 中读取数据 & 传出数据到通道
            fcout.write(buff);

            // 7. 重置缓冲区
            buff.clear();
        }
    }
}
