package org.springframework.luozlspringtest.springsource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.luozlspringtest.springsource.spring08.Furniture;
import org.springframework.luozlspringtest.springsource.spring24.ClassA;
import org.springframework.luozlspringtest.springsource.spring24.ClassB;

public class Spring24Test {
    private XmlBeanFactory xmlBeanFactory;
    @Before
    public void initXmlBeanFactory() {
        System.setProperty("spring.profiles.active", "dev");
        System.out.println("\n========测试方法开始=======\n");
        xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring24/spring24.xml"));
    }

    @After
    public void after() {
        System.out.println("\n========测试方法结束=======\n");
    }

    @Test
    public void test12() {
        //循环依赖测试
        //Spring只能解决Setter方法注入的单例bean之间的循环依赖
        //ClassA依赖ClassB，ClassB又依赖ClassA，形成依赖闭环。
        // Spring在获取ClassA的实例时，不等ClassA完成创建就将其曝光加入正在创建的bean缓存中。
        // 在解析ClassA的属性时，又发现依赖于ClassB，再次去获取ClassB，当解析ClassB的属性时，
        // 又发现需要ClassA的属性，但此时的ClassA已经被提前曝光加入了正在创建的bean的缓存中，
        // 则无需创建新的的ClassA的实例，直接从缓存中获取即可。从而解决循环依赖问题。
        ClassA classA= (ClassA) xmlBeanFactory.getBean("classA");
        ClassB classB= (ClassB) xmlBeanFactory.getBean("classB");
        System.out.println(classA);
        System.out.println(classB);
    }
}
