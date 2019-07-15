package org.springframework.luozlspringtest.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setUserName("张三");
        user.setAge(26);
        userService.insert(user);

        List<User> list = userService.getList();
        for(User user1:list)
        {
            System.out.println("姓名："+user1.getUserName()+",今年："+user1.getAge());
        }
    }
}
