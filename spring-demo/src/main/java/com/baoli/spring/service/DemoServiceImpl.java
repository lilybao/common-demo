package com.baoli.spring.service;

import com.baoli.spring.api.DemoService;
import com.baoli.spring.entity.SysLog;
import com.baoli.spring.service.mapper.DemoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: common-demo
 * @description: demoService实现列
 * @author: li baojian
 * @create: 2020-03-18 18:00
 */
@Service
public class DemoServiceImpl extends ServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public void save(SysLog sysLog) {
        this.save(sysLog);
    }
}
