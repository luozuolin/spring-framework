package org.springframework.luozlspringtest;

import org.springframework.beans.factory.annotation.Autowired;

public class MyTestBean {
    @Autowired
    BeanNameAwareTest beanNameAwareTest;
    private String   testStr="testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}
