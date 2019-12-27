package com.baoli.thread.tickets;

/**
 * @description: 计数器
 * @author: li baojian
 * @create: 2019/10/25 14:33
 */
public class Counter {
    private int count;


    public int getCount(){
        return count;
    }
    public synchronized void addCount(){
        count++;
    }

}
