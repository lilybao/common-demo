package com.baoli.designmode.abstractfacotry.sendmsg;

/**
 * @description: 发送短信
 * @author: li baojian
 * @create: 2019/09/25 17:39
 */
public class SendSms implements Sender {
    @Override
    public void send() {
        System.out.println("this is send sms!");
    }
}
