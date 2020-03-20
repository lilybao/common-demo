package com.baoli.test.designmode;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-20 18:22
 */
public class PlayDemo2 extends AbstractPlay {
    @Override
    public void init(String name) {
        System.out.println("PlayDemo2初始化"+name);
    }
}
