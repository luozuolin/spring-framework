package org.springframework.luozlspringtest.springsource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.luozlspringtest.springsource.spring06.Cat;

public class Spring06Test {
    private XmlBeanFactory xmlBeanFactory;
    @Before
    public void initXmlBeanFactory() {
        System.setProperty("spring.profiles.active", "dev");
        System.out.println("\n========测试方法开始=======\n");
        xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring06/Cat.xml"));
    }

    @After
    public void after() {
        System.out.println("\n========测试方法结束=======\n");
    }
    @Test
    public void test5() {
        // 注入集合属性
        Cat cat = xmlBeanFactory.getBean("cat", Cat.class);
        cat.sayListNames();
        cat.saySetNames();
        cat.sayArrayNames();
        cat.sayMapNames();
        cat.sayPropertiesNames();
    }

}

