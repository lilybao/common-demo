package com.baoli.designmode.decorator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @description: 日志装饰器
 * @author: li baojian
 * @create: 2019/12/25 15:24
 */
public class LoggerDecorator implements Command {
    Command command;

    public LoggerDecorator(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        Log log = LogFactory.getLog(this.getClass());
        log.info("日志装饰器开始");
        System.out.println("日志装饰器开始");
        this.command.execute();
        System.out.println("日志装饰器结束");
        log.info("日志装饰器结束");
    }
}
