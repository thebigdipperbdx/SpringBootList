package com.sto.pattern.prototype;

/**
 * @author yanyugang
 * @description 原型模式
 * @date 2019/9/11 21:56
 */
public class PrototypePatternTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("Strong message", underlinePen);
        manager.register("Waring Box", mbox);
        manager.register("Slash Box", sbox);
        Product p1 = manager.create("Strong message");
        p1.use("hello world");
        Product p2 = manager.create("Waring Box");
        p2.use("hello world");
        Product p3 = manager.create("Slash Box");
        p3.use("hello world");
    }
}
