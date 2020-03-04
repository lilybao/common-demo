package com.baoli.leetcode.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 异步执行三个方法  调用同一个实例的不同方法 实现顺序打印功能
 */
public class FooDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newScheduledThreadPool(5);
        Executors.newSingleThreadExecutor()
        Foo foo = new Foo();
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        ThreadThree threadThree = new ThreadThree();
        executorService.submit(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(threadThree);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        executorService.submit(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(threadTwo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        executorService.submit( new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(threadOne);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        executorService.shutdown();
//        Foo foo = new Foo();
//        try {
//            foo.first(threadOne);
//            foo.second(threadTwo);
//            foo.third(threadThree);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    foo.first(threadOne);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    foo.second(threadTwo);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    foo.third(threadThree);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }
}
