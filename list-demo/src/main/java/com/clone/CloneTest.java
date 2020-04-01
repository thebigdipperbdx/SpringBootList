package com.clone;

/**
 * @author yanyugang
 * @description 深拷贝
 * @date 2019-11-13 20:01
 */
public class CloneTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("Hello");

        User user = new User();
        user.setName("TianMing");
        user.setTeacher(teacher);

        User user2 = (User) user.clone();
        // 浅拷贝中引用类型的变量拷贝的是对象的引用
        System.out.println("user==user2 " + (user == user2) + "  user.teacher==user2.teacher " + (user.getTeacher() == user2.getTeacher()));

        System.out.println(user);
        System.out.println(user2);

        user.getTeacher().setName("World");

        System.out.println(user);
        System.out.println(user2);


    }
}
