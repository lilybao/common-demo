package com.baoli.springboot.dubbo.service;

import com.baoli.springboot.dubbo.api.ConsumerService;
import com.baoli.springboot.dubbo.api.ProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 服务消费类
 * @author: li baojian
 * @create: 2020/01/16 14:06
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);
    @Reference(version = "${api.service.version}", url = "${api.service.url}")
    private ProviderService providerService;

    @Override
    public String findDemo(String name) {
        String demo = providerService.getDemo(name);
        logger.info("调用远程服务成功:返回结果:{}", demo);
        return demo;
    }

}
