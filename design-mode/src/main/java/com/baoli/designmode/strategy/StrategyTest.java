package com.baoli.designmode.strategy;

/**
 * @description: 策略模式测试
 * 通过设置不同的策略（算法）来完成某件事情
 * 策略可以进行更换  根据需要不同的算法
 * @author: li baojian
 * @create: 2020/01/18 17:15
 */
public class StrategyTest {
    public static void main(String[] args) {
        Person person = new Person();
        HighSpeedRail highSpeedRail = new HighSpeedRail();
        person.setTravelBehavior(highSpeedRail);
        person.useTraffic();
        AirPlane airPlane = new AirPlane();
        person.setTravelBehavior(airPlane);
        person.useTraffic();

    }
}
