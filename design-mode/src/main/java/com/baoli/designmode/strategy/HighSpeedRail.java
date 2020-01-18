package com.baoli.designmode.strategy;

/**
 * @description: 高铁
 * @author: li baojian
 * @create: 2020/01/18 17:13
 */
public class HighSpeedRail implements TravelBehavior {
    @Override
    public void useTraffic() {
        System.out.println("坐高铁");
    }
}
