package org.springframework.luozlspringtest.springsource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.luozlspringtest.springsource.spring05.Outer;
import org.springframework.luozlspringtest.springsource.spring05.Son;
public class Spring05Test {
    private XmlBeanFactory xmlBeanFactory;
    @Before
    public void initXmlBeanFactory() {
        System.setProperty("spring.profiles.active", "dev");
        System.out.println("\n========测试方法开始=======\n");
        xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring05/InnerBean.xml"));
    }

    @After
    public void after() {
        System.out.println("\n========测试方法结束=======\n");
    }
    @Test
    public void test5() {
        // 内部bean
        Outer outer = xmlBeanFactory.getBean("outer", Outer.class);
        outer.sayHello();
    }

    @Test
    public void test6() {
        // 父子bean
        Son son = xmlBeanFactory.getBean("son", Son.class);
        son.sayHello();
    }
}
