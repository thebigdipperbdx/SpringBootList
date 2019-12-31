package com.me.controller;

/**
 * @author yanyugang
 * @description
 * 类的成员字段定义为 private ，并提供 get、set 方法
 * 体现了封装思想
 * @date 2019-12-27 9:17
 */
public class CreateObjectDemo {

    public static void main(String[] args) {
        Point point=new Point();
        // x 为私有属性，用提供的 public 方法调用
        System.out.println("Point x="+point.getX());
        // y 为公有属性，既可以用 point.y ，也可以用 point.getY()
        System.out.println("Point y="+point.y);
        System.out.println("Point y="+point.getY());
        // 不利于控制权限
        point.y=8;
        System.out.println("Point y="+point.getY());

    }
}