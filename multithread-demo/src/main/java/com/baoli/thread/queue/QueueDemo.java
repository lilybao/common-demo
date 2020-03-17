package com.baoli.thread.queue;

import java.util.concurrent.*;

/**
 * @program: common-demo
 * @description: 队列demo
 * @author: li baojian
 * @create: 2020-03-17 15:27
 */
public class QueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        queue.add("sdf");
        LinkedTransferQueue<Object> queue1 = new LinkedTransferQueue<>();
        queue1.add("sdfds");
        LinkedBlockingQueue<Object> queue2 = new LinkedBlockingQueue<>();
        queue2.add("sdf");
        ArrayBlockingQueue queue3 = new ArrayBlockingQueue<Object>(10);
        queue3.add("sdf");
        SynchronousQueue<Object> queue4 = new SynchronousQueue<>();
        queue4.add("sdfs");
    }
}
