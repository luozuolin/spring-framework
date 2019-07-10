package org.springframework.luozlspringtest.BeanFactoryPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.luozlspringtest.User;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanFactoryPostProcessor.xml");

        User user = (User)context.getBean("user");
        System.out.println(user.getName());
    }
}
