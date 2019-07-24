package org.springframework.luozlspringtest.springsource;

import org.junit.Test;
import org.springframework.luozlspringtest.springsource.spring40.MyTransaction;

public class Spring40Test {
    @Test
    public   void Test(){
        MyTransaction myTransaction=new MyTransaction();
        myTransaction.save();
    }
}
