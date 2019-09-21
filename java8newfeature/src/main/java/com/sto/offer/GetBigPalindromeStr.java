package com.sto.offer;

import java.util.HashSet;

/**
 * @author yanyugang
 * @description
 * LeetCode: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。
 * 比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
 * @date 2019-09-20 9:21
 */
public class GetBigPalindromeStr {
    public  int longestPalindrome(String s) {
        if (s.length() == 0){
            return 0;
        }
        // 用于存放字符
        HashSet<Character> hashset = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
                hashset.add(chars[i]);
            } else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
                hashset.remove(chars[i]);
                count++;
            }
        }
        return hashset.isEmpty() ? count * 2 : count * 2 + 1;
    }

}
