package com.baoli.designmode.decorator;

/**
 * @description: ���ܷ���װ����
 * @author: li baojian
 * @create: 2019/12/25 15:27
 */
public class PerFormanceDecorator implements Command {
    Command command;

    public PerFormanceDecorator(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println("���ܷ�������ʼ");
        this.command.execute();
        System.out.println("���ܷ���������");
    }
}
