package com.baoli.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 排它锁中  公平锁和非公平锁
 * 非公平锁效率高于公平锁
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        int tickets = 0;
        int total = 10000;
        SaleTicket saleTicket = new SaleTicket(tickets, total);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= total; i++) {
            TicketThread ticketThread = new TicketThread(saleTicket);
            executorService.submit(ticketThread);
        }
        executorService.shutdown();
    }

    private static void saleTickets(int tickets, ReentrantLock reentrantLock) {
        reentrantLock.lock();
        tickets--;
        System.out.println(Thread.currentThread().getName() + "第" + tickets + "张票出票");
        reentrantLock.unlock();
    }

    static class SaleTicket {
        int tickets = 0;
        int total;

        public SaleTicket(int tickets, int total) {
            this.tickets = tickets;
            this.total = total;
        }

        //默认使用非公平锁  构造true为公平锁
        private final ReentrantLock reentrantLock = new ReentrantLock();
//        private final ReentrantLock reentrantLock = new ReentrantLock(true);
        long startTime;

        public void saleTickets() {
            reentrantLock.lock();
            if (tickets == 1) {
                startTime = System.currentTimeMillis();
            }
            tickets++;
            System.out.println(Thread.currentThread().getName() + "第" + tickets + "张票出票");
            if (tickets == total) {
                System.out.println("花了" + (System.currentTimeMillis() - startTime) + "时间售完票");
            }
            reentrantLock.unlock();
        }
    }
}
