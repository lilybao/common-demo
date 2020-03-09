package com.baoli.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: common-demo
 * @description: 利用CAS实现单例模式
 * @author: li baojian
 * @create: 2020-03-09 12:01
 */
public class CasSigleTonDemo {
    //保证在多个线程下是可见的
    private static final AtomicReference<CasSigleTonDemo> instance = new AtomicReference<>();
    //私有化构造方法
    private CasSigleTonDemo() {
    }
    //cas确保线程安全
    public static final CasSigleTonDemo getInstance() {
        while (true) {
            CasSigleTonDemo casSigleTonDemo = instance.get();
            if (casSigleTonDemo != null) {
                return casSigleTonDemo;

            }
            casSigleTonDemo = new CasSigleTonDemo();
            if (instance.compareAndSet(null, casSigleTonDemo)) {
                return casSigleTonDemo;
            }
        }

    }

    public static void main(String[] args) {
        CasSigleTonDemo instance = CasSigleTonDemo.getInstance();
        CasSigleTonDemo instance1 = CasSigleTonDemo.getInstance();
        System.out.println(instance==instance1);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    CasSigleTonDemo casSingleTon = CasSigleTonDemo.getInstance();
                    System.out.println(casSingleTon);
                }
            });
        }
        executorService.shutdown();
    }
}
