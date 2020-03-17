package com.baoli.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @program: common-demo
 * @description: Spring工具类
 * @author: li baojian
 * @create: 2020-03-17 11:05
 */
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    //根据类名获取bean
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
    //通过class获取ben
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
    //通过类名和class获取bean
    public static <T> T getBean(String name,Class<T> clazz){
        return applicationContext.getBean(name,clazz);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }
}
