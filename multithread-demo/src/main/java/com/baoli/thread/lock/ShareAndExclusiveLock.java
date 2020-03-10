package com.baoli.thread.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: common-demo
 * @description: 共享锁和独享锁
 * 共享锁对于并发读效率很高
 * 多个线程进行查看票剩余和售票的操作，保证售出的票数字都是在查看的票数字之后，即 售出的票是正确的（存在的）
 * @author: li baojian
 * @create: 2020-03-10 09:31
 */
public class ShareAndExclusiveLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        int count = 100;
        TicketSale ticketSale = new TicketSale(count);
        //并发读
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    ticketSale.getCount();
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    ticketSale.saleTicket();
                }
            });
        }
        executorService.shutdown();

    }

    static class TicketSale {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        int count;

        public TicketSale(int count) {
            this.count = count;
        }

        public void getCount() {
            ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "剩余票" + count);
            lock.unlock();
        }

        public void saleTicket() {
            ReentrantReadWriteLock.WriteLock lock = reentrantReadWriteLock.writeLock();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "售出第" + count-- + "张票");
            lock.unlock();
        }
    }


}
