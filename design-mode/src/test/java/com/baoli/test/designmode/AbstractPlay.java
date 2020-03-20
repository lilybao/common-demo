package com.baoli.test.designmode;

/**
 * @program: common-demo
 * @description: 抽象play
 * @author: li baojian
 * @create: 2020-03-20 18:21
 */
public abstract class AbstractPlay {
    protected abstract void init(String name);

    public void refresh(){
        this.init("AbstractPlay");
    }

    public static void main(String[] args) {
        PlayDemo1 playDemo1 = new PlayDemo1();
        playDemo1.refresh();
    }
}
