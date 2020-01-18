package com.baoli.designmode.strategy;

/**
 * @description: 游客
 * @author: li baojian
 * @create: 2020/01/18 17:14
 */
public class Person {
    TravelBehavior travelBehavior;

    public void useTraffic() {
        if (null != travelBehavior) {
            travelBehavior.useTraffic();
        }
    }

    public void setTravelBehavior(TravelBehavior travelBehavior) {
        this.travelBehavior = travelBehavior;
    }
}
