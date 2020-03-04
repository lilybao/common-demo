package com.baoli.thread.main;

import org.junit.Test;

import java.util.concurrent.*;

public class mainThreadDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "完成任务");
            }
        });
        for (int i = 0; i < 10; i++) {
            try {
                CaculatorTask caculatorTask = new CaculatorTask(cyclicBarrier, i);
                caculatorTask.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 栅栏循环屏障
     * 使用10个线程进行计算任务，计算完成之后合并结果
     */
    @Test
    public void test2() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "完成任务");

            }
        });
        for (int i = 0; i < 20; i++) {
            try {
                new CaculatorTask(cyclicBarrier, i).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "主线程结束");
//        try {
//            //此处睡眠5秒钟，如果不睡眠主线程会提前执行结束，导致子线程不能完全执行完
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void test3() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "完成任务");

            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Caculator1Task(cyclicBarrier, i));
        }
        System.out.println(Thread.currentThread().getName() + "主线程结束");
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Caculator1Task implements Runnable {
        CyclicBarrier cyclicBarrier;
        int i;

        public Caculator1Task(CyclicBarrier cyclicBarrier, int i) {
            this.cyclicBarrier = cyclicBarrier;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println(i + Thread.currentThread().getName() + "子线程开始等待");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    static class CaculatorTask extends Thread {
        CyclicBarrier cyclicBarrier;
        int i;

        public CaculatorTask(CyclicBarrier cyclicBarrier, int i) {
            this.cyclicBarrier = cyclicBarrier;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println(i + Thread.currentThread().getName() + "子线程开始等待");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
