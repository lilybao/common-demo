package com.baoli.spring.api;

import com.baoli.spring.entity.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;

public interface DemoService extends IService {
    void save(SysLog sysLog);
}
