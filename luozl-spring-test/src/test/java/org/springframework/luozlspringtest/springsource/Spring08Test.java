package org.springframework.luozlspringtest.springsource;

import org.junit.*;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.luozlspringtest.springsource.spring08.Furniture;

public class Spring08Test {
    private XmlBeanFactory xmlBeanFactory;
    @Before
    public void initXmlBeanFactory() {
        System.setProperty("spring.profiles.active", "dev");
        System.out.println("\n========测试方法开始=======\n");
        xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring08/spring08.xml"));
    }

    @After
    public void after() {
        System.out.println("\n========测试方法结束=======\n");
    }

    @Test
    public void test9() {
        /**
         * xmlBeanFactory.getBean("student") 获取到的是StudentFactoryBean产生的实例，
         * 也就是Student类的实例；而xmlBeanFactory.getBean("&student")获取到的是
         * StudentFactoryBean自己的实例。
         */
        Object object1 = xmlBeanFactory.getBean("student");
        Object object2 = xmlBeanFactory.getBean("&student");
        System.out.println(xmlBeanFactory.getBean("student"));
        System.out.println(xmlBeanFactory.getBean("&student"));
    }
    @Test
    public void test12() {
        //FactoryBean简单工厂测试
        Furniture furniture = xmlBeanFactory.getBean("furniture", Furniture.class);
        furniture.sayHello();
    }
}
