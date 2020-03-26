package com.baoli.designmode.spi;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-26 11:53
 */
public class SpiServiceImpl1 implements SpiService {
    @Override
    public void execute() {
        System.out.println("execute SpiServiceImpl1 class");
    }
}
