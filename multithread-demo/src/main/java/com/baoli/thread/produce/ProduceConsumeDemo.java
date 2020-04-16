package com.baoli.thread.produce;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: common-demo
 * @description: 生产者消费者模型
 * @author: li baojian
 * @create: 2020-04-16 09:52
 */
public class ProduceConsumeDemo {
    private volatile ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    public volatile static int i;

    public void produce() {
        synchronized (this) {
            while (queue.size() == 10) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(i++);
            System.out.println(Thread.currentThread().getName()+" add  "+(i-1));
            notifyAll();
        }
    }

    public void consume() {
        synchronized (this) {
            while (queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" " +queue.poll()+"  queue  size :"+queue.size());
            notifyAll();
        }
    }

    private volatile static AtomicInteger count=new AtomicInteger();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ProduceConsumeDemo produceConsumeDemo = new ProduceConsumeDemo();

        for (int j = 0; j < 2; j++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    for (int k = 0; k < 100; k++) {
                        produceConsumeDemo.consume();
                    }
                }
            });
        }
        for (int j = 0; j < 2; j++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    for (int k = 0; k < 100; k++) {
                        produceConsumeDemo.produce();
                    }
                }
            });
        }
        executorService.shutdown();

    }
}
