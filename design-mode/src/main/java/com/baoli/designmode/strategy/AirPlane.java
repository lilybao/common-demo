package com.baoli.designmode.strategy;

/**
 * @description: 飞机
 * @author: li baojian
 * @create: 2020/01/18 17:12
 */
public class AirPlane implements TravelBehavior {
    @Override
    public void useTraffic() {
        System.out.println("坐飞机");
    }
}
