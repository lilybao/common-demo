package com.baoli.spring.common.base.service.impl;

import com.baoli.spring.common.base.mapper.BaseMapper;
import com.baoli.spring.common.base.model.BaseModel;
import com.baoli.spring.common.base.service.BaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: common-demo
 * @description: base
 * @author: li baojian
 * @create: 2020-03-19 12:26
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseModel> extends ServiceImpl<M, T> implements BaseService<T> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
