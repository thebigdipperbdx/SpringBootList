package com.sto.pattern.adapter;

/**
 * @author yanyugang
 * @description 适配器类
 * @date 2019/9/15 21:39
 */
public class Adapter implements Target {
    /*
     * 持有需要被适配的接口对象
     */
    private Adaptee adaptee;

    /*
     * 构造方法，传入需要被适配的对象
     * @param adaptee 需要被适配的对象
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
