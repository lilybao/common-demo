package com.baoli.designmode.abstractfacotry.sendmsg;

/**
 * @description: 发送短信工厂
 * @author: li baojian
 * @create: 2019/09/25 17:52
 */
public  class SendsmsFactory extends Provider {
    @Override
    public Sender produce() {
        return new SendSms();
    }
}
