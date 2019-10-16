package com.sto.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yanyugang
 * @description Socket服务端
 * 1、创建ServerSocket对象绑定监听端口
 * 2、通过accept()方法监听客户端的请求
 * 3、建立连接后，通过输入流读取客户端发送的请求信息
 * 4、通过输出流向客户端发送请求信息
 * 5、关闭相关资源
 * @date 2019-10-16 9:23
 */
public class SocketServer {
    public static void main(String[] args){
        // 监听指定的端口
        int port=55533;
        System.out.println("server准备好了.......");
        // try-with-resource
        try (ServerSocket server=new ServerSocket(port);
             Socket socket=server.accept();
             InputStream inputStream=socket.getInputStream();
             OutputStream outputStream=socket.getOutputStream();) {

            byte[] bytes=new byte[1024];
            int len;
            StringBuffer buffer=new StringBuffer();
            // 只有当客户端关闭它的输出流的时候，服务端才能取得结尾的-1
            while ((len=inputStream.read(bytes))!=-1) {
                // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                buffer.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println("get message from client: " + buffer.toString());
            outputStream.write("Hello Client,I get the message.".getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
