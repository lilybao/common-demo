package com.baoli.spring.common.util;

import com.baoli.spring.entity.SysLog;
import com.baoli.spring.service.mapper.DemoMapper;

import java.util.Queue;
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
            DemoMapper demoMapper = SpringUtil.getBean(DemoMapper.class);
            demoMapper.insert(sysLog);
            queue.remove(sysLog);
        }
    }
}
