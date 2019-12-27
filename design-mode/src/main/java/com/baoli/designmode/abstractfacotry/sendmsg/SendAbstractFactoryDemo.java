package com.baoli.designmode.abstractfacotry.sendmsg;

import org.junit.Test;

/**
 * @description: 测试抽象工厂发送消息
 * @author: li baojian
 * @create: 2019/09/25 17:53
 */
public class SendAbstractFactoryDemo {
    /**
     * 如果需要拓展发送消息的功能 只需要 重新实现工厂接口 即可
     */
    @Test
    public void testSend(){
        SendEmailFactory sendEmailFactory = new SendEmailFactory();
        sendEmailFactory.produce().send();
        SendsmsFactory sendsmsFactory = new SendsmsFactory();
        sendsmsFactory.produce().send();
    }
}
