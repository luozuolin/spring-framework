package org.springframework.luozlspringtest.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OrderInvocationHandler  implements InvocationHandler {
    // 目标对象
    private Object target;

    public OrderInvocationHandler(Object target)
    {
        super();
        this.target= target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method1");
        Object result = method.invoke(target,args);
        System.out.println("After method1");
        return result;
    }
    public Object getProxy()
    {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }
}
