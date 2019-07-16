package org.springframework.luozlspringtest.springsource.spring04;

public class DogStaticFactory {
    // 静态工厂方法
    public static Dog newInstance(String name, int age) {
        // 返回需要的Bean实例
        return new Dog(name, age);
    }
}
