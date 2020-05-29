package com.baoli.dynamicsource.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program: common-demo
 * @description: 动态数据源
 * @author: li baojian
 * @create: 2020-05-29 15:26
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}
