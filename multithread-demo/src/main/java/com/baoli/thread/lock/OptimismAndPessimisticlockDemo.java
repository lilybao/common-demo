package com.baoli.thread.lock;

import com.baoli.thread.main.MyThread;
import org.junit.Test;

import java.sql.Time;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: common-demo
 * @description: 乐观锁，悲观锁
 * @author: li baojian
 * @create: 2020-03-09 09:51
 */
public class OptimismAndPessimisticlockDemo {
    public static void main(String[] args) {
        int sum = 100;
        Ticket1 ticket = new Ticket1(sum);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < sum; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    ticket.sale();
                }
            });
        }
        executorService.shutdown();



    }

    /**
     * 乐观锁  不加锁  使用concurrent下的并发变量
     * 线程丢失问题
     */
    @Test
    public void test1() {
        int sums = 100;
//        AtomicStampedReference<Object> objectAtomicStampedReference = new AtomicStampedReference<>();
        AtomicInteger sum = new AtomicInteger(sums);
        Ticket2 ticket = new Ticket2();
        HashMap<String, Integer> map = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        int j = 0;
        for (int i = 0; i < sum.longValue(); i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    if (map.get(Thread.currentThread().getName()) == null) {
                        map.put(Thread.currentThread().getName(), 1);
                    } else {
                        map.put(Thread.currentThread().getName(), map.get(Thread.currentThread().getName()) + 1);
                    }

                    ticket.sale(sum);
                }
            });
        }
        executorService.shutdown();
        while (true){
            if(executorService.isTerminated()){
                break;
            }else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        int num=0;
        for (String key :
                map.keySet()) {
            num+=map.get(key);
            System.out.println(key+"="+map.get(key));
        }
        System.out.println(num);
//        try {
//            Thread.sleep(1000);
//            int num=0;
//            for (String key :
//                    map.keySet()) {
//                num+=map.get(key);
//                System.out.println(key+"="+map.get(key));
//            }
//            System.out.println(num);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            executorService.shutdown();
//        }

    }

    class MyThread implements Runnable {

        @Override
        public void run() {

        }
    }
    /**
     * 悲观锁  synchronized实现
     */
    static class Ticket {
        int sum;
        public Ticket(int sum) {
            this.sum = sum;
        }
        public synchronized void sale() {
            System.out.println(Thread.currentThread().getName() + "售出了第" + sum-- + "张票");
        }
    }

    /**
     * 悲观锁  Lock实现
     */
    static class Ticket1 {
        int sum;
        ReentrantLock lock = new ReentrantLock();
        public Ticket1(int sum) {
            this.sum = sum;
        }
        public void sale() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "售出了第" + sum-- + "张票-lock");
            lock.unlock();
        }
    }
    /**
     * 乐观锁  AtomicInteger实现
     */
    static class Ticket2 {
        public void sale(AtomicInteger sum, CountDownLatch countDownLatch) {
            System.out.println(Thread.currentThread().getName() + "售出了第" + sum.decrementAndGet() + "张票-AtomicInteger");
            countDownLatch.countDown();
        }
        public void sale(AtomicInteger sum) {
            System.out.println(Thread.currentThread().getName() + "售出了第" + sum.decrementAndGet() + "张票-AtomicInteger");
        }
    }


}
