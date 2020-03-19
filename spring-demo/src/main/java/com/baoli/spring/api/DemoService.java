package com.baoli.spring.api;

import com.baoli.spring.common.base.service.BaseService;
import com.baoli.spring.entity.SysLog;

import java.util.List;

public interface DemoService extends BaseService<SysLog> {
    void saveSysLog(SysLog sysLog);

    List<SysLog> find(String name);
}
