package com.baoli.spring.annotation;

import com.baoli.spring.enums.LogTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {
    //日志类型
    LogTypeEnum logType();
    //日志标题
    String logTitle() default "";
}
