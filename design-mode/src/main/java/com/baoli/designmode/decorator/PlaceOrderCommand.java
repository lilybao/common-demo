package com.baoli.designmode.decorator;

/**
 * @description: �¶���������
 * @author: li baojian
 * @create: 2019/12/25 15:31
 */
public class PlaceOrderCommand implements Command {
    @Override
    public void execute() {
        System.out.println("�¶�������");
    }
}
