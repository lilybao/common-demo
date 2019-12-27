package com.baoli.designmode.decorator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @description: ��־װ����
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
        log.info("��־װ������ʼ");
        System.out.println("��־װ������ʼ");
        this.command.execute();
        System.out.println("��־װ��������");
        log.info("��־װ��������");
    }
}
