package com.clone;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-13 20:01
 */
public class User implements Cloneable {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    @Override
    protected Object clone() {
        User user=null;
        try {
            user=(User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public String toString(){
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }


}
