package org.springframework.luozlspringtest.springsource.spring04;

public class DogFactory {
    public Dog newInstance(String name, int age) {
        return new Dog(name, age);
    }
}
