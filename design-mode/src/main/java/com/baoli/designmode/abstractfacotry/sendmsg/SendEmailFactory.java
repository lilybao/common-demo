package com.baoli.designmode.abstractfacotry.sendmsg;

/**
 * @description: 发送邮件工厂
 * @author: li baojian
 * @create: 2019/09/25 17:43
 */
public class SendEmailFactory extends Provider {
    @Override
    public Sender produce() {
        return new SendEmail();
    }
}
