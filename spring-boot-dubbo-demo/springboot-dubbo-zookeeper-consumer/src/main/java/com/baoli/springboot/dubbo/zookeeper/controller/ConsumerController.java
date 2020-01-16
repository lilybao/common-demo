package com.baoli.springboot.dubbo.zookeeper.controller;

import com.baoli.springboot.dubbo.zookeeper.api.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 服务消费者 访问层
 * @author: li baojian
 * @create: 2020/01/16 16:19
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/consumer/find/{name}", method = RequestMethod.GET)
    public String find(@PathVariable("name") String name) {
        return consumerService.getDemo(name);
    }
}
