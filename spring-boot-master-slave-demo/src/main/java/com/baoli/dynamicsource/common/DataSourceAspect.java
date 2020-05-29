package com.baoli.dynamicsource.common;

import com.baoli.dynamicsource.annotation.DataSourceSelector;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @program: common-demo
 * @description: 动态数据源切面
 * @author: li baojian
 * @create: 2020-05-29 15:57
 */
@Aspect
@Slf4j
@Component
@Order(value = 1)
public class DataSourceAspect {

    @Around("@annotation(com.baoli.dynamicsource.annotation.DataSourceSelector)")
    public Object setDynamicDataSource(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        boolean clear = true;
        try {
            Method method = this.getMethod(proceedingJoinPoint);
            DataSourceSelector selector = method.getAnnotation(DataSourceSelector.class);
            clear = selector.clear();
            DataSourceContextHolder.set(selector.value().getDynamicDataSourceName());
            log.info("*****数据源切换至:{}******", selector.value().getDynamicDataSourceName());
            return proceedingJoinPoint.proceed();
        } finally {
            if (clear) {
                DataSourceContextHolder.remove();
            }
        }
    }

    private Method getMethod(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        return signature.getMethod();
    }
}
