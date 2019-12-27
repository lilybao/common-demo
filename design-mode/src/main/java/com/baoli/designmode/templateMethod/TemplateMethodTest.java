package com.baoli.designmode.templateMethod;

/**
 * @description: ģ�巽��������
 * @author: li baojian
 * @create: 2019/12/25 15:07
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        PlaceOrderCommand placeOrderCommand = new PlaceOrderCommand();
        placeOrderCommand.execute();
        PayMoneyCommand payMoneyCommand = new PayMoneyCommand();
        payMoneyCommand.execute();
    }
}
