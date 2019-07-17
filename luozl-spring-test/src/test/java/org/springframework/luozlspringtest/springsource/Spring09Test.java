package org.springframework.luozlspringtest.springsource;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.luozlspringtest.springsource.spring09.LifeCycleBean;

public class Spring09Test {
    @After
    public void after() {
        System.out.println("\n========测试方法结束=======\n");
    }

    @Test
    public void test9() {
        /*** 生命周期测试 输出如下：
         * setBeanName called:myLifeCycleBean
         * setBeanFactory called:org.springframework.beans.factory.support.DefaultListableBeanFactory@3ba9ad43: defining beans [myLifeCycleBean,myBeanPostProcessor]; root of factory hierarchy
         * setApplicationContext called.
         * 04-->调用postProcessBeforeInitialization方法, 获取到的beanName: myLifeCycleBean
         * afterPropertiesSet called.
         * 06-->myInit方法被调用了
         * 07-->调用postProcessAfterInitialization, 获取到的beanName: myLifeCycleBean
         * 08-->bean可以被使用了, beanInfo: LifeCycleBean{name='李四', age=30}
         * 七月 17, 2019 3:15:59 下午 org.springframework.context.support.ClassPathXmlApplicationContext doClose
         * 信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@8e24743: startup date [Wed Jul 17 15:15:22 CST 2019]; root of context hierarchy
         * destroy called.
         * 10-->自定义destroy-method方法被调动了
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring09/spring09.xml");
        LifeCycleBean myLifeCycleBean = applicationContext.getBean("myLifeCycleBean", LifeCycleBean.class);
        System.out.println("08-->bean可以被使用了, beanInfo: " + myLifeCycleBean.toString());
        ((ClassPathXmlApplicationContext) applicationContext).destroy();
    }
}