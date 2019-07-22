package org.springframework.luozlspringtest.springsource.spring04;

public class Dog {
    private String name;
    private int age;
    public void sayHello() {
        System.out.println("大家好, 我叫" + getName() + ", 我今年" + getAge() + "岁了");
    }
    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
