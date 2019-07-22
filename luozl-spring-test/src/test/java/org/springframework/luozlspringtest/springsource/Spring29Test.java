package org.springframework.luozlspringtest.springsource;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.luozlspringtest.springsource.spring29.Animal;
import org.springframework.luozlspringtest.springsource.spring29.Dog;
import org.springframework.luozlspringtest.springsource.spring29.MyMethodBeforeAdvice;
import org.springframework.luozlspringtest.springsource.spring29.MyStaticPointcutAdvisor;

public class Spring29Test {
    @Test
    public   void test(){
        // 1、创建目标类、增强、切入点
        Animal animal = new Dog();
        MyMethodBeforeAdvice advice = new MyMethodBeforeAdvice();
        MyStaticPointcutAdvisor advisor = new MyStaticPointcutAdvisor();

        // 2、创建ProxyFactory并设置目标类、增强、切面
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(animal);
        // 为切面类提供增强
        advisor.setAdvice(advice);
        proxyFactory.addAdvisor(advisor);
       // proxyFactory.addAdvice(advice);

        // 3、生成代理实例
        Dog proxyDog = (Dog) proxyFactory.getProxy();
        proxyDog.sayHelloDog();
        System.out.println("\n\n");
        proxyDog.sayHello();
    }
}
