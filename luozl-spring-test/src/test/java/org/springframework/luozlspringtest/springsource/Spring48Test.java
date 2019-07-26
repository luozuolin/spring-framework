package org.springframework.luozlspringtest.springsource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.luozlspringtest.springsource.spring48.BankService;

public class Spring48Test {
    @Test
    public  void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring48/spring48.xml");
        BankService service = ctx.getBean("bankService", BankService.class);
        service.save();
    }
}
