package org.springframework.luozlspringtest.springsource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.luozlspringtest.springsource.spring30.Cat;
import org.springframework.luozlspringtest.springsource.spring30.Dog;

public class Spring30Test {
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring30/spring30.xml");
        Cat cat = ctx.getBean("cat", Cat.class);
        cat.sayHello("美美", 3);
    }
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring30/spring30new.xml");
        Dog dog = ctx.getBean("dog", Dog.class);
        dog.sayHello("美美", 3);
    }
}
