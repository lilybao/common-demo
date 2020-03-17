package com.baoli.spring.controller;

import com.baoli.spring.annotation.Log;
import com.baoli.spring.enums.LogTypeEnum;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: common-demo
 * @description: 测试controller
 * @author: li baojian
 * @create: 2020-03-17 11:44
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/test1/{name}", method = RequestMethod.GET)
    @Log(logType = LogTypeEnum.BUSINESS, logTitle = "测试test")
    public String test1(@PathVariable(value = "name") String name) {
        return name+"测试成功";
    }
}
