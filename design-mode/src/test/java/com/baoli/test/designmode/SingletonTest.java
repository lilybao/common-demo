package com.baoli.test.designmode;

import com.baoli.designmode.singleton.SingletonDemo;
import org.junit.Test;

/**
 * @description: 单例模式测试
 * @author: li baojian
 * @create: 2019/10/18 16:27
 */
public class SingletonTest {
    @Test
    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonDemo instance = SingletonDemo.getInstance();
                System.out.println(instance.toString());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonDemo instance = SingletonDemo.getInstance();
                System.out.println(instance.toString());
            }
        }).start();
    }
}
