package com.baoli.springboot.dubbo.controller;

import com.baoli.springboot.dubbo.api.ConsumerService;
import com.baoli.springboot.dubbo.service.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 服务访问层
 * @author: li baojian
 * @create: 2020/01/16 14:13
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/comsumer/find/{name}", method = RequestMethod.GET)
    public String find(@PathVariable("name") String name) {
        return consumerService.findDemo(name);
    }
}
