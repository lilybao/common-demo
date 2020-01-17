package com.baoli.designmode.adapter;

/**
 * @description: 学生1
 * @author: li baojian
 * @create: 2020/01/17 17:23
 */
public class StudentDemo implements Student {
    @Override
    public String learn() {
        return "读书学习";
    }
}
