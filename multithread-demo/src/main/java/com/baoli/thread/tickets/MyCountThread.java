package com.baoli.thread.tickets;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 计数器线程  继承Thread类实现一个线程
 * @author: li baojian
 * @create: 2019/10/25 14:35
 */
public class MyCountThread extends Thread {
    private Counter counter;
    private CountDownLatch countDownLatch;

    public MyCountThread(Counter counter, CountDownLatch countDownLatch) {
        this.counter = counter;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.addCount();
        }
        countDownLatch.countDown();
    }
}
