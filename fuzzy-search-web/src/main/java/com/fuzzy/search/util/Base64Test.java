package com.fuzzy.search.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Base64Utils;

/**
 * @author yanyugang
 * @description BASE64加密解密
 * @date 2019-08-15 14:41
 */
public class Base64Test {
    public static void main(String[] args){
        String str="Hello World";
        // spring core 工具类
        byte[] base64=Base64Utils.encode(str.getBytes());
        // commons-codec工具类
        byte[] bytes=Base64.encodeBase64(str.getBytes());
        String encodeString=new String(bytes);
        System.out.println("BASE64加密后===>" + encodeString);
        String decodeString=new String(Base64.decodeBase64(bytes));
        System.out.println("BASE64解密后===>" + decodeString);
    }
}
