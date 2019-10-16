package com.sto.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author yanyugang
 * @description 客户端
 * 1、创建Socket对象，指明需要连接的服务器的地址和端口
 * 2、建立连接后，通过输出流向服务器发送请求信息
 * 3、通过输入流获取服务器的响应信息
 * 4、关闭响应资源
 * @date 2019-10-16 9:44
 */
public class SocketClient {
    public static void main(String args[]){
        // 要连接的服务端IP地址和端口
        String host="127.0.0.1";
        int port=55533;
        // 与服务端建立连接
        // 建立连接后获得输出流
        // try-with-resource
        try (Socket socket=new Socket(host, port);
             OutputStream outputStream=socket.getOutputStream();
             InputStream inputStream=socket.getInputStream();) {

            String message="Hello,Tian Ming";
            outputStream.write(message.getBytes("UTF-8"));
            // 通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
            socket.shutdownOutput();


            byte[] bytes=new byte[1024];
            int len;
            StringBuffer buffer=new StringBuffer();
            while ((len=inputStream.read(bytes))!=-1) {
                // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                buffer.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println("get message from server: " + buffer.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
