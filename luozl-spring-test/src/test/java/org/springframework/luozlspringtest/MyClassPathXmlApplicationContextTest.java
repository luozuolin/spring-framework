package org.springframework.luozlspringtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext bf = new MyClassPathXmlApplicationContext("beanFactoryTest.xml");

        System.out.println("end..");
    }
}
