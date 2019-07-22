package org.springframework.luozlspringtest.springsource.spring27;

public class CountProxy implements  Count{
    Count count;
    public CountProxy(Count count){
        this.count=count;
    }
    @Override
    public void queryCout() {
        System.out.println("开始查询。。。");
        count.queryCout();
        System.out.println("结束查询。。。");

    }

    @Override
    public void updateCount() {
        System.out.println("开始更新。。。");
        count.updateCount();
        System.out.println("结束更新。。。");

    }
}
