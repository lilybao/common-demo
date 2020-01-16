package com.baoli.springboot.dubbo.zookeeper.service;

import com.baoli.springboot.dubbo.api.ProviderService;
import com.baoli.springboot.dubbo.zookeeper.api.ConsumerService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 服务消费者实现类
 * @author: li baojian
 * @create: 2020/01/16 16:02
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    private Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);
    @Reference(version = "${api.service.version}")
    private ProviderService providerService;

    @Override
    public String getDemo(String name) {
        String demo = providerService.getDemo(name);
        logger.info("远程调用服务成功返回值:{}",demo);
        return demo;
    }
}
