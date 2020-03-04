package com.baoli.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index + Thread.currentThread().getName());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }



    @Test
    public void test1() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index + Thread.currentThread().getName());
                        countDownLatch.countDown();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        try {
            System.out.println("等待子线程执行结束");
            countDownLatch.await();
            System.out.println("子线程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");

    }






    @Test
    public void test() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index + Thread.currentThread().getName());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
