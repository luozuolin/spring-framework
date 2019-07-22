package org.springframework.luozlspringtest.springsource.spring27;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private  Object target;
    public MyInvocationHandler(Object target){
        super();
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法之前。。。");
        Object invoke=method.invoke(target,args);
        System.out.println("调用方法之后。。。");
        return invoke;
    }
    //代理对象
    public Object getProxy() {
        /**
         * 参数：
         * 1、获取当前线程的类加载
         * 2、获取接口
         * 3、当前对象
         * 代理类$Proxy被声明为final类，继承Proxy类并实现了JDKAnimal接口，
         * 重写了equals、toString、hashCode等方法，当然最重要的还是实现了
         * JDKAnimal接口中的sayHello方法，并通过静态代码块拿到了
         * sayHello方法的信息
         */
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
