package com.baoli.spring.common.base.service.impl;

/**
 * @program: common-demo
 * @description: ServiceImpl
 * @author: li baojian
 * @create: 2020-03-19 14:26
 */

import com.baoli.spring.common.base.mapper.BaseMapper;
import com.baoli.spring.common.base.model.BaseModel;

public abstract class ServiceImpl<M extends BaseMapper<T>, T extends BaseModel> extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<M, T> {
}
