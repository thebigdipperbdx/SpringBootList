package com.sto.pattern.decorator;

/**
 * @author yanyugang
 * @description 结构型模式--装饰器模式
 * @date 2019-09-06 11:27
 */
public class DecoratorPatternTest {
    public static void main(String[] args){
        IPacketCreator pc=new PacketHTTPHeaderCreator(
                new PacketHTMLHeaderCreator(
                        new PacketBodyCreator()));
        System.out.println(pc.handleContent());
    }
}
