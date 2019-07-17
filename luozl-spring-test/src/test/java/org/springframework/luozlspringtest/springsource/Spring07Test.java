package org.springframework.luozlspringtest.springsource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.luozlspringtest.springsource.spring06.Cat;
import org.springframework.luozlspringtest.springsource.spring07.Car;
import org.springframework.luozlspringtest.springsource.spring07.OriginalDog;
import org.springframework.luozlspringtest.springsource.spring07.Taxi;

public class Spring07Test {
    private XmlBeanFactory xmlBeanFactory;
    @Before
    public void initXmlBeanFactory() {
        System.setProperty("spring.profiles.active", "dev");
        System.out.println("\n========测试方法开始=======\n");
        xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring07/spring07.xml"));
    }

    @After
    public void after() {
        System.out.println("\n========测试方法结束=======\n");
    }
    @Test
    public void test5() {
        // 测试lookup-method注入
        Car car1 = xmlBeanFactory.getBean("car", Car.class);
        Car car2 = xmlBeanFactory.getBean("car", Car.class);

        System.out.println("Car:singleton,所以animal1==animal2应该为" + (car1 == car2));

        Taxi dog1 = car1.getTaxi();
        Taxi dog2 = car2.getTaxi();
        System.out.println("Taxi:prototype,Car:singleton,未使用lookup-method注入所以dog1==dog2应该为" + (dog1 == dog2));

        //注意:这里是通过createDog()方法获取
        Taxi taxi3 = car1.createTaxi();
        Taxi taxi4 = car2.createTaxi();
        System.out.println("Taxi:prototype,Car:singleton,使用了lookup-method注入所以dog3==dog4应该为" + (taxi3 == taxi4));

    }
    @Test
    public void test9() {
        //测试replace-method注入
        OriginalDog originalDog = xmlBeanFactory.getBean("originalDogReplaceMethod", OriginalDog.class);
        originalDog.sayHello("输出结果已经被替换了。。。");
    }
}
