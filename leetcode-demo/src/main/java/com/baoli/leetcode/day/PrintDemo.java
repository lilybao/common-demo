package com.baoli.leetcode.day;

/**
 * @program: common-demo
 * @description: 打印奇数和偶数
 * @author: li baojian
 * @create: 2020-04-15 17:42
 */
public class PrintDemo {
    public static boolean state = true;

    public static void main(String[] args) {

    }

    static class Counter{
        int val;
    }

    static class Thread1Demo extends Thread {
         Counter counter;

        public Thread1Demo(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                } else {
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Thread2Demo extends Thread {
        private static Thread2Demo instance = null;

        public static Thread2Demo getInstance() {
            if (instance == null) {
                instance = new Thread2Demo();
            }
            return instance;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 1) {
                    System.out.println(i);
                } else {
                    try {
                        getInstance().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
