package com.baoli.thread.tickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @description: 线程测试主类
 * @author: li baojian
 * @create: 2019/10/25 13:55
 */
public class ThreadDemo1 {
    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++) {
        testTicketsDemo();
//        }
    }

    private static void testTicketsDemo() {
        int threadCount = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            MyTicketsThread myTicketsThread = new MyTicketsThread("窗口" + i, countDownLatch);
            Future submit = executorService.submit(myTicketsThread);
            futures.add(submit);
        }
        executorService.shutdown();
        try {
            //等待所有子线程结束后，主线程再向下进行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第一次模拟售票结束=================================");
        System.out.println("第一次模拟售票结果=================================");
        try {
            for (Future f :
                    futures) {
                System.out.println(f.get().toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void testCountDemo() {
        Counter counter = new Counter();
        int threadCount = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new MyCountThread(counter, countDownLatch).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }


    private static void testDemo() {
        List<Object> list = new Vector<>();
        int threadCount = 1000;
        //模拟1000个线程
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //启动threadCount个线程
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new MyThread(list, countDownLatch));
            thread.start();
        }
        try {
            //主线程等待所有子线程完成之后，再向下执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
