package org.springframework.luozlspringtest.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBTest {
    //为什么会多次打印Before invoke，After invoke？
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLIBTest.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        CGLIBTest test = (CGLIBTest)enhancer.create();
        test.test();
        System.out.println(test);
    }

    public void test()
    {
        System.out.println("CGLIB Test");
    }

    private static class MethodInterceptorImpl implements MethodInterceptor
    {
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("Before invoke");
            Object result = methodProxy.invokeSuper(o,objects);
            System.out.println("After invoke");
            return result;
        }
    }
}
