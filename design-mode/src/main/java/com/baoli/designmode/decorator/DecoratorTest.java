package com.baoli.designmode.decorator;

/**
 * @description: װ����ģʽ������
 * @author: li baojian
 * @create: 2019/12/25 15:28
 */
public class DecoratorTest {
    public static void main(String[] args) {
        //���¶��������������ͳ�ƺ���־����
        Command command = new LoggerDecorator(new PerFormanceDecorator(new PlaceOrderCommand()));
        command.execute();
        //��֧�����������־����
        Command command1 = new LoggerDecorator(new PayMoneyCommand());
        command1.execute();
    }
}
