package com.baoli.designmode.adapter;

/**
 * @description: 教师动作
 * @author: li baojian
 * @create: 2020/01/17 17:28
 */
public class TeacherDemo implements Teacher {
    @Override
    public String teach() {
        return "教书育人";
    }
}
