package org.springframework.luozlspringtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        MyTestBean myTestBean= (MyTestBean) bf.getBean("myTestBean");
        System.out.println(myTestBean.getTestStr());
        myTestBean.setTestStr("123");
        System.out.println(myTestBean.getTestStr());
        BeanNameAwareTest beanNameAwareTest= (BeanNameAwareTest) bf.getBean("beanNameAwareTest");

    }
}
