package org.springframework.luozlspringtest.springsource;

import org.junit.Test;
import org.springframework.luozlspringtest.springsource.spring27.*;

import java.lang.reflect.Proxy;

public class Spring27test {
    /***
     * 静态代理
     */
    @Test
    public void countProxyTest(){
        Count count=new CountImpl();
        CountProxy countProxy=new CountProxy(count);
        countProxy.queryCout();
        System.out.println("");
        countProxy.updateCount();
    }
    @Test
    public void JDKProxyTest(){
        /***
         * 代理类$Proxy被声明为final类，继承Proxy类并实现了JDKAnimal接口，
         * 重写了equals、toString、hashCode等方法，当然最重要的还是实现了
         * JDKAnimal接口中的sayHello方法，并通过静态代码块拿到了sayHello
         * 方法的信息
         */
      //  JDKAnimal jdkAnimal=new JDKDog();
      //JDKAnimal jdkAnimal1= (JDKAnimal) Proxy.newProxyInstance(jdkAnimal.getClass().getClassLoader(),jdkAnimal.getClass().getInterfaces(),new MyInvocationHandler(jdkAnimal));
      //  jdkAnimal1.sayHello();
        MyInvocationHandler handler = new MyInvocationHandler(new JDKDog());
        JDKAnimal proxy = (JDKAnimal) handler.getProxy();
        proxy.sayHello();
    }
    @Test
    public  void cglibTest(){
        // CGLIB动态代理
        CglibCat cat = (CglibCat) new MyCglibProxy().getInstance(CglibCat.class);
        cat.sayHello();
    }

}
