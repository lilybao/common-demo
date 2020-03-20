package com.baoli.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: common-demo
 * @description: jdk动态代理
 * @author: li baojian
 * @create: 2020-03-20 15:41
 */
public class ProxyJdkDemo implements InvocationHandler {
    //需要代理的类
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理,监听开始");
        Object invoke = method.invoke(target, args);
        System.out.println("JDK动态代理,监听结束");
        return invoke;
    }
    public Object getProxyJdkObject(Object targetObject){
        this.target=targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }
}
