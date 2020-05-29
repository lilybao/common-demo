package com.baoli.dynamicsource.service.mapper;

import com.baoli.dynamicsource.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> list();

    void update(Student student);

    Student selector(Integer id);
}
