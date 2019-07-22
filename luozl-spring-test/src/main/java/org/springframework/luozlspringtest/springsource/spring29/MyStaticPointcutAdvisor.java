package org.springframework.luozlspringtest.springsource.spring29;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

public class MyStaticPointcutAdvisor extends StaticMethodMatcherPointcutAdvisor {
    private static String METHOD_NAME = "sayHello";
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return METHOD_NAME.equals(method.getName());
    }
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return Dog.class.isAssignableFrom(clazz);
            }
        };
    }
}
