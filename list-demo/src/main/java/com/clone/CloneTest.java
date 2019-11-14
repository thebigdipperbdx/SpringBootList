package com.clone;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-13 20:01
 */
public class CloneTest {
    public static void main(String[] args){
        User user=new User();
        user.setName("TianMing");
        System.out.println(user);
        User user1=(User) user.clone();
        System.out.println(user1);
    }
}
