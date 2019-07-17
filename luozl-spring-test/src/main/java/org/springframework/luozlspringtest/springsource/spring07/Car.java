package org.springframework.luozlspringtest.springsource.spring07;

public abstract class Car {
    //用于lookup-method注入
    public abstract Taxi createTaxi();

    private Taxi taxi;

    public Taxi getTaxi() {
        return taxi;
    }

    //setter注入
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }
}
