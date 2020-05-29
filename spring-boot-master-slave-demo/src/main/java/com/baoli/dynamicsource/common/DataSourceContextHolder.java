package com.baoli.dynamicsource.common;

/**
 * @program: common-demo
 * @description: 数据源 存储到每个线程中
 * @author: li baojian
 * @create: 2020-05-29 15:28
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> DATASOURCE_CONTEXT = new ThreadLocal<>();

    public static void set(String datasourceType) {
        DATASOURCE_CONTEXT.set(datasourceType);
    }

    public static String get() {
        return DATASOURCE_CONTEXT.get();
    }

    public static void remove() {
        DATASOURCE_CONTEXT.remove();
    }

}
