package com.baoli.designmode.abstractfacotry.sendmsg;

/**
 * @description: 发送消息工厂接口
 * @author: li baojian
 * @create: 2019/09/25 17:41
 */
public abstract class Provider {
    abstract Sender produce();
}
