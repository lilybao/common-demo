package com.baoli.designmode.adapter;

/**
 * @description: the interface of Student learn  with sample method of the interface of Teacher teach
 * @author: li baojian
 * @create: 2020/01/17 17:26
 */
public class AdapterTest {

    public static void main(String[] args) {
        Teacher teacherDemo = new TeacherDemo();
        Student student = new TeacherAdapter(teacherDemo);
        System.out.println(student.learn());
    }
}
