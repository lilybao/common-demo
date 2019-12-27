package com.baoli.designmode.singleton;

/**
 * @description: 单例模式demo
 * @author: li baojian
 * @create: 2019/09/25 18:16
 */
public class SingletonDemo {

    private static SingletonDemo singletonDemo=null;

    /**
     * 私有构造方法 防止被实例化
     */
    private SingletonDemo() {
    }

    public static SingletonDemo getInstance(){
        if(null == singletonDemo){
            return new SingletonDemo();
        }
        return singletonDemo;
    }
}
