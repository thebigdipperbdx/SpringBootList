package com.clone;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-13 20:01
 */
public class User implements Cloneable {
    private String name;
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // 重写 clone 方法
    @Override
    protected Object clone() {
        User user = null;
        try {
            user = (User) super.clone();
            Teacher teacher= (Teacher) this.teacher.clone();
            user.setTeacher(teacher);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public String toString() {
        return "User{name=" + name + "} Teacher{name=" + teacher.getName() + "}";
    }


}
