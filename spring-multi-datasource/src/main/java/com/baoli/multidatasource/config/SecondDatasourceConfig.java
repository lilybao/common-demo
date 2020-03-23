package com.baoli.multidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @program: common-demo
 * @description: 从数据库配置
 * @author: li baojian
 * @create: 2020-03-23 18:07
 */
@Configuration
@MapperScan(basePackages = "com.baoli.multidatasource.mapper.second",sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDatasourceConfig {

    @Bean(name = "secondDatasource")
    @ConditionalOnProperty(prefix = "spring.datasource.second")
    public DataSource getSecondDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/second/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
