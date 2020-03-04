package com.baoli.sql.batch;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @description: 自动配置类
 * @author: li baojian
 * @create: 2020/01/19 15:09
 */
@Configuration
public class SqlDemoAutoConfiguration {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = null;
        try {

            dataSource = jdbcTemplate.getDataSource();
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
