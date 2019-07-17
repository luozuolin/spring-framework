package org.springframework.luozlspringtest.springsource.spring09;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifeCycleBean implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {
    // 姓名
    private String name;
    // 年龄
    private int age;
    public void myInit() {
        System.out.println("06-->myInit方法被调用了");
    }
    public void myDestroy() {
        System.out.println("10-->自定义destroy-method方法被调动了");
    }
    @Override
    public String toString() {
        return "LifeCycleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory called:"+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName called:"+name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy called.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext called.");
    }
}
