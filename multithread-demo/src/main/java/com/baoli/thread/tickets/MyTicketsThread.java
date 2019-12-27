package com.baoli.thread.tickets;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 售票线程   五个窗口卖100张票
 * @author: li baojian
 * @create: 2019/10/25 14:59
 */
public class MyTicketsThread implements Callable<String> {
    private static AtomicInteger count = new AtomicInteger(100);
    private String name;
    private CountDownLatch countDownLatch;

    public MyTicketsThread(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        while (count.get() > 0) {
//             synchronized (this){
            sum++;
            System.out.println(name + "售出第" + (count.decrementAndGet()) + "张票");
//             }
        }
        countDownLatch.countDown();
        return name + "一共售出" + sum + "张票";
    }
}
