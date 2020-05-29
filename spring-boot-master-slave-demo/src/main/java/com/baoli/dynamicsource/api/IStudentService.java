package com.baoli.dynamicsource.api;

import com.baoli.dynamicsource.model.Student;

import java.util.List;

/**
 * @program: common-demo
 * @description: 学生接口
 * @author: li baojian
 * @create: 2020-05-29 16:13
 */
public interface IStudentService {
    List<Student> list();

    Student update(Student student);

    Student selector(Integer id);
}
