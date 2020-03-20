package com.baoli.designmode.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: common-demo
 * @description: cglib动态代理
 * @author: li baojian
 * @create: 2020-03-20 15:53
 */
public class ProxyCglibDemo implements MethodInterceptor {
    //需要代理的对象
    private Object target;
    //重写拦截方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理,监听开始");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib动态代理,监听结束");
        return invoke;
    }

    public Object getProxyCglibObject(Object targetObject) {
        this.target = targetObject;
        Enhancer enhancer = new Enhancer();
        //cglib是生成目标类的子类所以要指定父类
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);//设置回调
        Object result = enhancer.create();
        return result;
    }
}
