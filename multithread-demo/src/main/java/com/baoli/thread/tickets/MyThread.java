package com.baoli.thread.tickets;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 线程模拟集合中插入100个对象
 * @author: li baojian
 * @create: 2019/10/25 13:56
 */
public class MyThread implements Runnable {
    private List<Object> list;
    private CountDownLatch countDownLatch;
    public MyThread(List<Object> list, CountDownLatch countDownLatch) {
        this.list = list;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

        }
        countDownLatch.countDown();
    }
}
