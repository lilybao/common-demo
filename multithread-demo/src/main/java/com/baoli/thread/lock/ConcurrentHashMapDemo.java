package com.baoli.thread.lock;

import java.util.HashMap;

/**
 * @program: common-demo
 * @description: ConcurrentHashMap
 * @author: li baojian
 * @create: 2020-03-10 15:44
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1","3w");
        map.get("1");
        System.out.println(-1|-1>>>10);
        System.out.println(3<<1);
        int n=9;
        int i = tableSizeFor(0);
        System.out.println( i);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1<<30);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 50000) ? 50000 : n + 1;
    }
}
