package com.sto.collection;

/**
 * @author yanyugang
 * @description 静态内部类
 * @date 2019/9/8 20:59
 */
public class OutClass {
    public static class InnerClass {
        public InnerClass() {
            System.out.println("innerClass");
        }

        private static int count = 0;
    }

    public static void main(String[] args) {
        InnerClass b = new InnerClass();
        InnerClass c = new InnerClass();
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(InnerClass.count);
    }
}
