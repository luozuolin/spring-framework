package org.springframework.luozlspringtest.springsource.spring08;

public class Chair implements Furniture {
    @Override
    public void sayHello() {
        System.out.println("I'm a chair");
    }
}
