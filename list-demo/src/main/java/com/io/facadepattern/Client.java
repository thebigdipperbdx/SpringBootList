package com.io.facadepattern;

/**
 * @author yanyugang
 * @description 客户角色
 * @date 2019-09-29 16:38
 */
public class Client {
    public static void main(String[] args){
        Facade facade=new Facade();
        facade.method();
    }
}
