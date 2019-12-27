package com.baoli.designmode.factorymethod;

import org.junit.Test;

/**
 * @description: 普通工厂模式
 * @author: li baojian
 * @create: 2019/09/25 17:03
 */
public class FactoryMethodDemo {

    /**
     * 普通工厂模式
     */
    @Test
    public void testSender() {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.produce("email");
        sender.send();
    }

    /**
     * 多个工厂方法
     */
    @Test
    public void testMultiMethodSender(){
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.produceEmail();
        sender.send();
        Sender sender1 = senderFactory.produceSms();
        sender1.send();
    }

    /**
     * 静态方法模式
     */
    @Test
    public void testStaticMultiSender(){
        SenderFactory.produceEmail().send();
        SenderFactory.produceSms().send();
    }

}
