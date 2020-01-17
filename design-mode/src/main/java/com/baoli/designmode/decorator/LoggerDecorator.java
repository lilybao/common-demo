package com.baoli.designmode.decorator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: ????????
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
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.info("???????????");
        System.out.println("???????????");
        this.command.execute();
        System.out.println("????????????");
        log.info("????????????");
    }
}
