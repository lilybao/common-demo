package com.baoli.dynamicsource.common;

import lombok.Getter;

/**
 * @program: common-demo
 * @description: 动态数据源枚举类
 * @author: li baojian
 * @create: 2020-05-29 15:15
 */
@Getter
public enum DynamicDataSourceEnum {
    MASTER("master"),
    SLAVE("slave");
    private String dynamicDataSourceName;

    DynamicDataSourceEnum(String dynamicDataSourceName) {
        this.dynamicDataSourceName = dynamicDataSourceName;
    }
}
