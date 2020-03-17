package com.baoli.spring.util;

import com.baoli.spring.entity.SysLog;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: common-demo
 * @description: 日志保存线程
 * @author: li baojian
 * @create: 2020-03-17 14:37
 */
public class SaveLogThread extends Thread {
    public static final AtomicReference<SaveLogThread> instance = new AtomicReference<>();
    public Queue<SysLog> queue = new LinkedTransferQueue<>();

    private SaveLogThread() {
    }

    public static SaveLogThread getInstance() {
        while (true) {
            SaveLogThread saveLogThread = instance.get();
            if (saveLogThread != null) {
                return saveLogThread;
            }
            saveLogThread = new SaveLogThread();
            if (instance.compareAndSet(null, saveLogThread)) {
                return saveLogThread;
            }
        }
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            SysLog sysLog = queue.poll();
            System.out.println("主线程"+Thread.currentThread().getName() +"子线程"+instance.get().getName()+ "保存syslog" + sysLog.toString());
            queue.remove(sysLog);
        }
    }
}
