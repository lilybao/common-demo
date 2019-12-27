package com.baoli.designmode.factorymethod;

/**
 * @description: 发送短信
 * @author: li baojian
 * @create: 2019/09/25 17:17
 */
public class SendSms implements Sender {
    @Override
    public void send() {
        System.out.println("sms发送成功");
    }
}
