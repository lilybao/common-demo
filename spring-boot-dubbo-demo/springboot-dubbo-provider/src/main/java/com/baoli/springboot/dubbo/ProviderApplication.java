package com.baoli.springboot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @description: 服务提供者快速启动类
 * @author: li baojian
 * @create: 2020/01/16 10:50
 */
@EnableAutoConfiguration
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
