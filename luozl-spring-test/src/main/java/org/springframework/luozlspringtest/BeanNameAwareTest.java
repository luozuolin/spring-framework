package org.springframework.luozlspringtest;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

public class BeanNameAwareTest implements BeanNameAware {
    private String beanName = null;
    @Autowired
  public   MyTestBean myTestBean;
    @Override
    public void setBeanName(String name) {
        beanName=name;
    }
}
