package com.fuzzy.search.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author yanyugang
 * @description
 * 自定义bean可以实现InitializingBean接口，IOC容器启动时，Bean工厂初始化该自定义bean的属性后，
 * 会调用一次afterPropertiesSet方法，开发者可以在afterPropertiesSet方法中执行自定义初始化，
 * 或仅检查是否已设置所有必需属性，设置完成，注入到IOC容器中
 * @date 2019-10-18 13:15
 */
@Component
public class TestInitializingBean implements InitializingBean {
    private String name;
    private boolean flag;
    private int age;
    private Integer num;

    @Override
    public void afterPropertiesSet() throws Exception{
        System.out.println("--------BeanFactory初始化完成--------");
        System.out.println("--------检查是否已设置所有必需属性--------");
        System.out.println("--------自定义初始化--------");
    }
}
