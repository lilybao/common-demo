package com.baoli.thread.main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadParam {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        String result = "";
        for (int i = 0; i < 10; i++) {
            MyThread myThread = null;
            try {
                Future<String> future = executorService.submit(new MyThread1(result, i));
                if(!future.isDone()){
                    System.out.println(i+"等待中");
                }
                result+=future.get();
//                MyThread1 myThread1 = new MyThread1(result, i);
//                result += myThread1.call();
//                myThread = new MyThread(result, i);
//                myThread.start();
//                myThread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            result += myThread.result;
        }
        executorService.shutdown();
        System.out.println(result);
    }

    static class MyThread extends Thread {
        private String result;
        private int i;

        public MyThread(String result, int i) {
            this.result = result;
            this.i = i;
        }

        @Override
        public void run() {
            result = i + "结果";
            System.out.println("子线程运行结束");
        }
    }

    static class MyThread1 implements Callable<String> {
        private String result;
        private int i;

        public MyThread1(String result, int i) {
            this.result = result;
            this.i = i;
        }

        @Override
        public String call() throws Exception {
            result = i + "结果";
            System.out.println("子线程运行结束");
            return result;
        }
    }
}
