package com.baoli.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: common-demo
 * @description: Lock使用
 * @author: li baojian
 * @create: 2020-03-13 09:58
 */
public class LockDemo {
    public static void main(String[] args) {
//        Lock lock = new Lock();
//        lock.lock();
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lockInterruptibly();
//        test();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Test test = new Test();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    private synchronized static void test() {

    }

    static class Test {
        private Lock lock = new ReentrantLock();

        public void insert(Thread thread) throws InterruptedException {
            lock.lockInterruptibly();  //响应中断的使用方法
            System.out.println(thread.getName() + "获取了锁");
            long l = System.currentTimeMillis();
            try {
                while (true) {
                    if (System.currentTimeMillis() - l > Integer.MAX_VALUE) {
                        break;
                    }
                }
            } finally {
                System.out.println(Thread.currentThread().getName() + "执行了finally");
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            }
        }
    }

   static class MyThread extends Thread {
        Test test;

        public MyThread(Test test) {
            this.test = test;
        }

        @Override
        public void run() {
            try {
                test.insert(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }

        }
    }
}
