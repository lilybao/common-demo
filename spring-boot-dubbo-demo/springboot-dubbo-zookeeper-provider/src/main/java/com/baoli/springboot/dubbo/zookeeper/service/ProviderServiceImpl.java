package com.baoli.springboot.dubbo.zookeeper.service;

import com.baoli.springboot.dubbo.api.ProviderService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @description: 服务提供者实现类
 * @author: li baojian
 * @create: 2020/01/16 15:43
 */
@Service(version = "${api.service.version}")
public class ProviderServiceImpl implements ProviderService {
    private Logger logger = LoggerFactory.getLogger(ProviderServiceImpl.class);
    /**
     * the default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String servicename;

    @Override
    public String getDemo(String name) {
        logger.info("远程服务:{}被调用:{}",servicename,name);
        return String.format("[%s] hello :%s",servicename,name);
    }
}
