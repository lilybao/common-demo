package com.baoli.dynamicsource.service;

import com.alibaba.druid.pool.ha.selector.DataSourceSelectorEnum;
import com.baoli.dynamicsource.annotation.DataSourceSelector;
import com.baoli.dynamicsource.api.IStudentService;
import com.baoli.dynamicsource.common.DynamicDataSourceEnum;
import com.baoli.dynamicsource.model.Student;
import com.baoli.dynamicsource.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-05-29 16:33
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    @DataSourceSelector(value = DynamicDataSourceEnum.MASTER)
    public Student update(Student student) {
        student.setName("李四");
        student.setAge(30);
        student.setScore(90);
        studentMapper.update(student);
        return student;
    }

    @Override
    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public Student selector(Integer id) {
        return studentMapper.selector(id);
    }
}
