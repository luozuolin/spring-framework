package org.springframework.luozlspringtest.springsource;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.luozlspringtest.springsource.spring28.Animal;
import org.springframework.luozlspringtest.springsource.spring28.Dog;
import org.springframework.luozlspringtest.springsource.spring28.MyMethodBeforeAdvice;

public class Spring28Test {
    @Test
    public   void test(){
        // 前置增强
        // 1、实例化bean和增强
      Animal dog = new Dog();
        MyMethodBeforeAdvice advice = new MyMethodBeforeAdvice();

        // 2、创建ProxyFactory并设置代理目标和增强
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(dog);
        proxyFactory.addAdvice(advice);

        // 3、生成代理实例
        Animal proxyDog = (Animal) proxyFactory.getProxy();
        proxyDog.sayHello("二哈", 3);
    }
    @Test
    public   void test1(){
        // 前置增强
        // 1、实例化bean和增强
        Dog dog = new Dog();
        MyMethodBeforeAdvice advice = new MyMethodBeforeAdvice();

        // 2、创建ProxyFactory并设置代理目标和增强
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(dog);
        proxyFactory.addAdvice(advice);

        // 3、生成代理实例
        Dog proxyDog = (Dog) proxyFactory.getProxy();
        proxyDog.sayHello("二哈", 3);
    }
}
