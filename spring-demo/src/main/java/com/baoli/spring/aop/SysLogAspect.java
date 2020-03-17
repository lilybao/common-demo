package com.baoli.spring.aop;

import com.alibaba.fastjson.JSONObject;
import com.baoli.spring.annotation.Log;
import com.baoli.spring.entity.SysLog;
import com.baoli.spring.util.SaveLogThread;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @program: common-demo
 * @description: 系统日志切面类  计算一个请求后台的执行时间
 * @author: li baojian
 * @create: 2020-03-17 11:14
 */
@Aspect
@Component
public class SysLogAspect {

    //切点 需要执行的方法
    @Pointcut("execution(public * com.baoli.spring.controller.*.*(..))")
    public void sysLog() {
    }

    //通知的逻辑
    @Around(value = "sysLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Throwable newThrowable = null;
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            newThrowable = throwable;
            throw newThrowable;
        } finally {
            long end = System.currentTimeMillis();
            saveLog(joinPoint, newThrowable, end ,start);
        }

    }

    private void saveLog(ProceedingJoinPoint joinPoint, Throwable newThrowable, long end, long start) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        if (null != log) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            if (request != null) {
                ArrayList<Object> list = new ArrayList<>();
                String params = "";
                try {
                    for (Object obj :
                            joinPoint.getArgs()) {
                        if (obj instanceof HttpServletRequest || obj instanceof MultipartFile || obj instanceof HttpServletResponse) {
                            continue;
                        }
                        list.add(obj);
                    }
                    params = JSONObject.toJSONString(list.toArray(new Object[list.size()]));
                } catch (Exception e) {

                }
                SysLog sysLog = new SysLog();
                sysLog.setLogTitle(log.logTitle());
                sysLog.setLogType(log.logType());
                sysLog.setRequestParams(params);
                sysLog.setTime(end-start);
                sysLog.setStartTime(new Date(start));
                sysLog.setEndTime(new Date(end));
                SaveLogThread saveLogThread = SaveLogThread.getInstance();
                saveLogThread.queue.offer(sysLog);
                if(!saveLogThread.isAlive()){
                    System.out.println(saveLogThread.getName()+"线程开始执行");
                    saveLogThread.run();
                }
                System.out.println(params);
            }

        }
    }
}
