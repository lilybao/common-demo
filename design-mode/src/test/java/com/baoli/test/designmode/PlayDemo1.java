package com.baoli.test.designmode;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-20 18:21
 */
public class PlayDemo1 extends AbstractPlay {
    @Override
    public void init(String name) {
        System.out.println("PlayDemo1初始化"+name);
    }
    public void test(){
        this.refresh();
    }
}
