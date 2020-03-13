package com.baoli.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: common-demo
 * @description: Lock使用
 * @author: li baojian
 * @create: 2020-03-13 09:58
 */
public class LockDemo {
    public static void main(String[] args) {
//        Lock lock = new Lock();
//        lock.lock();
        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lockInterruptibly();
        test();
    }

    private synchronized static void test() {

    }

    class Test{
        public void insert(Thread thread){
            System.out.println(thread.getName()+"获取了锁");
        }
    }
    class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println();
        }
    }
}
