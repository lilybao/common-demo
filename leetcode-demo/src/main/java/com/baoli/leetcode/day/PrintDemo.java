package com.baoli.leetcode.day;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: common-demo
 * @description: 打印奇数和偶数
 * @author: li baojian
 * @create: 2020-04-15 17:42
 */
public class PrintDemo {
    public static boolean state = true;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Counter counter = new Counter();
        executorService.submit(new Thread1Demo(counter));
        executorService.submit(new Thread2Demo(counter));
        executorService.shutdown();
    }

    static class Counter {
        int val = 1;
    }

    static class Thread1Demo implements Runnable {
        Counter counter;

        public Thread1Demo(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            while (counter.val <= 100) {
                synchronized (counter) {
                    if (counter.val % 2 == 0) {
                        System.out.println(counter.val++);
                        try {
                            counter.notify();
                            counter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else {
                        try {
                            System.out.println("偶数线程等待");
                            counter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }
    }

    static class Thread2Demo implements Runnable {
        Counter counter;

        public Thread2Demo(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            while (counter.val <= 100) {
                synchronized (counter) {
                    if (counter.val % 2 == 1) {
                        System.out.println(counter.val++);
                        try {
                            counter.notify();
                            counter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                    }
                }

            }
        }
    }

}
