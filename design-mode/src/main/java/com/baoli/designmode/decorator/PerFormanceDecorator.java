package com.baoli.designmode.decorator;

/**
 * @description: 性能分析装饰器
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
        System.out.println("性能分析器开始");
        this.command.execute();
        System.out.println("性能分析器结束");
    }
}
