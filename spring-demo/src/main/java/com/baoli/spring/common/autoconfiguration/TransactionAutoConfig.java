package com.baoli.spring.common.autoconfiguration;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;

/**
 * @program: common-demo
 * @description: 事务自动注入类
 * @author: li baojian
 * @create: 2020-03-17 17:34
 */
@Configuration
@AutoConfigureOrder(-100)
public class TransactionAutoConfig {
    public static final String AOP_POINTCUT_EXPRESSION="execution(public * com.baoli.spring.common.base.service.BaseService+.*(..))";

    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    //配置事务策略
    @Bean
    public TransactionInterceptor txAdvice(){
        //设置适用于增删改事务的管理模式
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        //设置回滚策略 当抛出对应的异常后 进行回滚（ 这里设置为Exception）
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
       //设置事务隔离级别 (存在事务则加入  不存在则新建事务)
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //设置传播行为（读已提交的数据）
        requiredTx.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        //设置适用于查询的事务管理模式
        RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
        //设置事务隔离级别（支持当前事务，如果没有事务，就以非事务的方式执行）
        readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
        //设置传播行为（读已提交的数据）
        readOnly.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        //设置事务只读（可以提高效率,声明该事务不会进行修改数据库数据的操作，可减轻数据库的压力）
        readOnly.setReadOnly(true);
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*",requiredTx);
        source.addTransactionalMethod("save*",requiredTx);
        source.addTransactionalMethod("delete*",requiredTx);
        source.addTransactionalMethod("update*",requiredTx);


        source.addTransactionalMethod("find*",readOnly);
        source.addTransactionalMethod("list*",readOnly);
        source.addTransactionalMethod("find*",readOnly);
        return new TransactionInterceptor(platformTransactionManager,source);
    }
    @Bean
    public Advisor txAdviceAdvisor(){
        //声明切点要切入的面
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        //设置需要切入的方法路径
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        //设置切面和配置好的事务
        return new DefaultPointcutAdvisor(pointcut,txAdvice());
    }

}
