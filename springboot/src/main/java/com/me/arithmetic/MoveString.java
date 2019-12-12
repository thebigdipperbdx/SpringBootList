package com.me.arithmetic;

/**
 * @author yanyugang
 * @description
 * 给定一个字符串，要求将字符串前面的若干个字符移动到字符串的尾部
 * @date 2019/12/12 22:43
 */
public class MoveString {

    public static String moveResult(String str, int prefix) {
        int length = str.length();
        StringBuffer buffer = new StringBuffer();
        if (prefix < length) {
            for (int i = prefix; i < length; i++) {
                buffer.append(str.charAt(i));
            }
            for (int i = 0; i < prefix; i++) {
                buffer.append(str.charAt(i));
            }
            return buffer.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        String str="abcdef";
        String result = moveResult(str, 3);
        System.out.println(result);
    }
}
