package com.sto.nio;

import java.nio.ByteBuffer;

public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        buffer.put("Hello World ".getBytes());
        buffer.put("Hello Java ".getBytes());
        buffer.put("Good Morning ".getBytes());
        System.out.println(buffer.toString());
        byte[] array = buffer.array();
        System.out.println(new String(array));
    }
}
