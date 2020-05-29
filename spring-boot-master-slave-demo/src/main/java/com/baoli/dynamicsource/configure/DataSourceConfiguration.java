package com.baoli.dynamicsource.configure;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baoli.dynamicsource.common.DynamicDataSource;
import com.baoli.dynamicsource.common.DynamicDataSourceEnum;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @program: common-demo
 * @description: 数据源自动配置类
 * @author: li baojian
 * @create: 2020-05-29 15:18
 */
@Configuration
@MapperScan(basePackages = "com.baoli.dynamicsource.service.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfiguration {

    //主库
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDs() {
        return DruidDataSourceBuilder.create().build();
    }

    //从库
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDs() {
        return DruidDataSourceBuilder.create().build();
    }

    //主从动态配置  从数据源可配置可不配置
    @Bean
    public DynamicDataSource dynamicDataSource(@Qualifier("masterDs") DataSource masterDataSource, @Autowired(required = false) @Qualifier("slaveDs") DataSource slaveDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> dataSources = new HashMap<>();
        dataSources.put(DynamicDataSourceEnum.MASTER.getDynamicDataSourceName(), masterDataSource);
        if (slaveDataSource != null) {
            dataSources.put(DynamicDataSourceEnum.SLAVE.getDynamicDataSourceName(), slaveDataSource);
        }
        dynamicDataSource.setTargetDataSources(dataSources);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        return dynamicDataSource;
    }

    //配置sqlSessionFactory  注入动态数据源
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    //配置sqlSessionTemplate
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //数据源事务管理器 更新其中的数据源为自定义的动态数据源
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dynamicDataSource") DataSource dataSouce) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSouce);
        return dataSourceTransactionManager;
    }

}
