package com.baoli.multidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @program: common-demo
 * @description: 主数据库配置
 * @author: li baojian
 * @create: 2020-03-23 18:06
 */
@Configuration
@MapperScan(basePackages = "com.baoli.multidatasource.mapper.primary",sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDatasourceConfig {
    @Bean(name = "primaryDatasource")
    @Primary
    @ConditionalOnProperty(prefix = "spring.datasource.primary")
    public DataSource getPrimaryDatasource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/primary/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
