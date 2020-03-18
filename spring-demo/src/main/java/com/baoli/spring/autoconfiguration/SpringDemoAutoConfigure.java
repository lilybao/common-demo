package com.baoli.spring.autoconfiguration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-17 14:18
 */
@Configuration
@ComponentScan("com.baoli.spring")
@MapperScan("com.baoli.spring.service.mapper")
public class SpringDemoAutoConfigure {
}
