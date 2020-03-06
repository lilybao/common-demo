package com.baoli.thread.lock;

public class TicketThread implements Runnable {
    private ReentrantLockDemo.SaleTicket saleTicket;

    public TicketThread(ReentrantLockDemo.SaleTicket saleTicket) {
        this.saleTicket = saleTicket;
    }

    @Override
    public void run() {
        saleTicket.saleTickets();
//        System.out.println(Thread.currentThread().getName()+"第"+saleTicket.tickets+"张票出票");
    }
}
