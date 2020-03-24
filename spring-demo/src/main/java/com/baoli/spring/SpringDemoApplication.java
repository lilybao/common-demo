package com.baoli.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @program: common-demo
 * @description: springdemo快速启动类
 * @author: li baojian
 * @create: 2020-03-17 14:14
 */
@SpringBootApplication
@EnableCaching
public class SpringDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }
}
