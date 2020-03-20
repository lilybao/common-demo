package com.baoli.designmode.proxy;

/**
 * @program: common-demo
 * @description: 实现类
 * @author: li baojian
 * @create: 2020-03-20 15:40
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        System.out.println("调用了保存方法");
        System.out.println("参数为"+user.getUsername()+"="+user.getAge());
    }

    @Override
    public void delete(User user) {
        System.out.println("调用了删除方法");
        System.out.println("参数为"+user.getUsername()+"="+user.getAge());
    }
}
