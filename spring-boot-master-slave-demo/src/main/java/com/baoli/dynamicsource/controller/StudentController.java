package com.baoli.dynamicsource.controller;

import com.baoli.dynamicsource.api.IStudentService;
import com.baoli.dynamicsource.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-05-29 17:06
 */
@RestController
public class StudentController {
    @Autowired
    IStudentService studentService;

    @ResponseBody
    @RequestMapping("/select")
    public String select(@RequestParam(value = "id") Integer id) {
        Student student = studentService.selector(id);
        return student.toString();
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(@RequestParam(value = "id") Integer id) {
        Student student = new Student();
        student.setId(id);
        studentService.update(student);
        return student.toString();
    }
}
