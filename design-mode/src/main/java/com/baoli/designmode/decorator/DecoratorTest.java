package com.baoli.designmode.decorator;

/**
 * @description: 装饰器模式测试类
 * @author: li baojian
 * @create: 2019/12/25 15:28
 */
public class DecoratorTest {
    public static void main(String[] args) {
        //给下订单操作添加性能统计和日志分析
        Command command = new LoggerDecorator(new PerFormanceDecorator(new PlaceOrderCommand()));
        command.execute();
        //给支付操作添加日志分析
        Command command1 = new LoggerDecorator(new PayMoneyCommand());
        command1.execute();
    }
}
