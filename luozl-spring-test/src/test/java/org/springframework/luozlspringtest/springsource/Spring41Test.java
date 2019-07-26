package org.springframework.luozlspringtest.springsource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.luozlspringtest.springsource.spring41.AccountServiceImp;
import org.springframework.luozlspringtest.springsource.spring41.AccountServiceImpNew;

public class Spring41Test {
    @Test
    public  void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring41/spring41.xml");
        AccountServiceImp studentService = ctx.getBean("accountService", AccountServiceImp.class);
        studentService.save();
    }
    @Test
    public void testNew(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring41/spring41New.xml");
        AccountServiceImpNew studentService = ctx.getBean("accountService", AccountServiceImpNew.class);
        studentService.save();
    }
}
