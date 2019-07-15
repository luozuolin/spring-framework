package org.springframework.luozlspringtest.aop;

public class InvocationTest {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();

        OrderInvocationHandler handler = new OrderInvocationHandler(orderService);

        OrderService proxy = (OrderService)handler.getProxy();
        proxy.pay(100);
    }
}
