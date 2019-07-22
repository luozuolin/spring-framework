package org.springframework.luozlspringtest.springsource.spring30;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DogAspect {
    @Pointcut("execution(* org.springframework.luozlspringtest.springsource.spring30..*.*(..))")
    public void test(){}
    @Before("test()")
    public void beforeTest(){
        System.out.println("--前置增强");
    }
    @After("test()")
    public void afterTest(){
        System.out.println("--后置最终增强");
    }
}
