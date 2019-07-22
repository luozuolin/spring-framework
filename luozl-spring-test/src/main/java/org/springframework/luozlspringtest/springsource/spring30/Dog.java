package org.springframework.luozlspringtest.springsource.spring30;

public class Dog implements Animal{
    @Override
    public void sayHello(String name, int age) {
        System.out.println("--被增强的方法");
    }

    @Override
    public void sayException(String name, int age) {
        System.out.println("--被增强的异常");
    }
}
