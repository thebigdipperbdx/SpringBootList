package com.me.guava.csv;

/**
 * @author yanyugang
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 * @description
 * The Java programming language also supports a few special escape sequences for char and String literals: \b (backspace),
 * \t (tab), \n (line feed), \f (form feed), \r (carriage return), \" (double quote), \' (single quote), and \\ (backslash).
 * @date 2019-12-13 8:53
 */
public class EscapeSequences {
    public static void main(String[] args){
        String str="Hello World\b";
        String str2="Hello World\n";
        String str3="Hello World\t\tHello";
        String str4="Hello World\f";
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        char t='\t';
        char tt='\'';
    }
}
