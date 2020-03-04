package com.baoli.designmode.adapter;

/**
 * @description: 教师适配类  把一个类的接口转换成用户需要的另一个类的功能
 * @author: li baojian
 * @create: 2020/01/17 17:25
 */
public class TeacherAdapter implements Student {
    Teacher teacher;

    public TeacherAdapter(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String learn() {
        return teacher.teach();
    }
}
