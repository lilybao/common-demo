package com.baoli.spring.service;

import com.baoli.spring.api.DemoService;
import com.baoli.spring.common.base.service.impl.BaseServiceImpl;
import com.baoli.spring.entity.SysLog;
import com.baoli.spring.service.mapper.DemoMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: common-demo
 * @description: demoService实现列
 * @author: li baojian
 * @create: 2020-03-18 18:00
 */
@Service
public class DemoServiceImpl extends BaseServiceImpl<DemoMapper, SysLog> implements DemoService {


    @Override
    public void saveSysLog(SysLog sysLog) {
        this.save(sysLog);
//        int i = 3 / 0;
    }

    @Override
    public List<SysLog> find(String name) {
        LambdaQueryWrapper<SysLog> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysLog::getLoginName, name);
        return this.list(queryWrapper);
    }
}
