package com.baoli.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 3; i++) {
            final int index = i;
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + "延迟五秒执行" + Thread.currentThread().getName());
                }
            }, 5, TimeUnit.SECONDS);
        }

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("每三秒执行一次"+Thread.currentThread().getName());
            }
        },2,3,TimeUnit.SECONDS);

    }
}
