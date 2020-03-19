package com.baoli.spring.controller;

import com.baoli.spring.common.annotation.Log;
import com.baoli.spring.api.DemoService;
import com.baoli.spring.entity.SysLog;
import com.baoli.spring.common.enums.LogTypeEnum;
import com.baoli.spring.common.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @program: common-demo
 * @description: 测试controller
 * @author: li baojian
 * @create: 2020-03-17 11:44
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/test1/{name}", method = RequestMethod.GET)
    @Log(logType = LogTypeEnum.BUSINESS, logTitle = "测试test")
    public String test1(@PathVariable(value = "name") String name) {
        return name+"测试成功";
    }


    @RequestMapping(value = "/save/{name}", method = RequestMethod.GET)
    @Log(logType = LogTypeEnum.BUSINESS, logTitle = "save")
    public String save(@PathVariable(value = "name") String name) {
        SysLog sysLog = new SysLog();
        sysLog.setUuid(UUID.randomUUID().toString());
        sysLog.setLogTitle("测试");
        sysLog.setLoginName(name);
        demoService.saveSysLog(sysLog);
        return name+"测试成功";
    }

    @RequestMapping(value = "/update/{name}", method = RequestMethod.GET)
    @Log(logType = LogTypeEnum.BUSINESS, logTitle = "update")
    @PostMapping
    public String update(@PathVariable(value = "name") String name) {
        SysLog sysLog = new SysLog();
        sysLog.setUuid(UUID.randomUUID().toString());
        sysLog.setLogTitle("测试");
        sysLog.setLoginName(name);
        demoService.saveSysLog(sysLog);
        return name+"测试成功";
    }

    @RequestMapping(value = "/list/{name}", method = RequestMethod.GET)
    public ResultData list(@PathVariable(value = "name") String name) {
        List<SysLog> sysLogs = demoService.find(name);
        return new ResultData(sysLogs);
    }

}
