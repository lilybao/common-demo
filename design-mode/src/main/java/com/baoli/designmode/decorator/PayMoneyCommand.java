package com.baoli.designmode.decorator;

/**
 * @description: 支付操作类
 * @author: li baojian
 * @create: 2019/12/25 15:31
 */
public class PayMoneyCommand implements Command {
    @Override
    public void execute() {
        System.out.println("支付操作");
    }
}
