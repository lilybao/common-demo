package com.baoli.designmode.proxy;

/**
 * @program: common-demo
 * @description: 用户
 * @author: li baojian
 * @create: 2020-03-20 15:38
 */

public class User {
    private String username;
    private String age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
