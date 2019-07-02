package org.springframework.luozlspringtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(UserDao.class);
        annotationConfigApplicationContext.refresh();
        UserDao  userDao= (UserDao) annotationConfigApplicationContext.getBean("userDao");
        userDao.query("select 1 from  student.");
    }
}
