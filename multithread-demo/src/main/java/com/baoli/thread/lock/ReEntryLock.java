package com.baoli.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: common-demo
 * @description: 重入锁和非可重入锁
 * 重入锁  一个线程获取在获取锁时，如果当前锁已经是该线程占有的，那么该线程会自动获取该锁
 * 非可重入锁  一个线程获取锁时，如果当前锁被占用，则进入阻塞状态
 * @author: li baojian
 * @create: 2020-03-10 09:08
 */
public class ReEntryLock {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        LockDemo lockDemo = new LockDemo();
        for (int i = 0; i < 4; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    lockDemo.test1();
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    lockDemo.test2();
                }
            });
        }
        executorService.shutdown();

    }

    static class LockDemo {
        public synchronized void test1() {
            System.out.println(Thread.currentThread().getName()+"test1-start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test2();
            System.out.println(Thread.currentThread().getName()+"test1-end");
        }

        public synchronized void test2() {
            System.out.println(Thread.currentThread().getName()+"test2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
