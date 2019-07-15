package org.springframework.luozlspringtest.aop;

import org.springframework.core.annotation.Order;

public class OrderServiceImpl implements OrderService {
    @Override
    public void pay(double money) {
        System.out.println("pay:"+money);
    }
}
