package org.springframework.luozlspringtest;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
    @Test
    public void beanFactoryTest(){
        BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean= (MyTestBean) beanFactory.getBean("myTestBean");
        System.out.println(myTestBean.getTestStr());
        myTestBean.setTestStr("123");
        System.out.println(myTestBean.getTestStr());
    }
}
