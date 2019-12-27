package com.baoli.designmode.factorymethod;

/**
 * @description: 发送邮件
 * @author: li baojian
 * @create: 2019/09/25 17:17
 */
public class SendEmail implements Sender {
    @Override
    public void send() {
        System.out.println("email 发送成功");
    }
}
