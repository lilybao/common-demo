package com.baoli.designmode.abstractfacotry.sendmsg;

/**
 * @description: 发送邮件类
 * @author: li baojian
 * @create: 2019/09/25 17:40
 */
public class SendEmail implements Sender {
    @Override
    public void send() {
        System.out.println("this is a email send!");
    }
}
