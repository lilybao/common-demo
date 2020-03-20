package com.baoli.designmode.proxy;

/**
 * @program: common-demo
 * @description:动态代理的两种实现方式
 * @author: li baojian
 * @create: 2020-03-20 15:46
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ProxyJdkDemo proxyJdkDemo = new ProxyJdkDemo();
        UserService userService =(UserService) proxyJdkDemo.getProxyJdkObject(new UserServiceImpl());

        ProxyCglibDemo proxyCglibDemo = new ProxyCglibDemo();
        UserService cglibService =(UserService) proxyCglibDemo.getProxyCglibObject(new UserServiceImpl());
        User user = new User();
        user.setAge("27");
        user.setUsername("lili");
        cglibService.delete(user);
        userService.save(user);
    }
}
