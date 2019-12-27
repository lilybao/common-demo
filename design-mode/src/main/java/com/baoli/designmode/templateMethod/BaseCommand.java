package com.baoli.designmode.templateMethod;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * @description: 模板方法中的模板抽象类
 * @author: li baojian
 * @create: 2019/12/25 14:59
 */
public abstract class BaseCommand {
   public static final Log log = LogFactory.getLog(BaseCommand.class);
    public void execute(){

        log.info("开始");
        //开始性能分析
        System.out.println(new Date());
        //开始事务
        System.out.println("开始事务");
        doBusiness();
        //结束事务
        System.out.println("提交事务");
        //性能分析结束
        System.out.println(new Date());
        log.info("结束");
    }
    //抽象方法之类必须实现
    protected abstract void doBusiness();
}
