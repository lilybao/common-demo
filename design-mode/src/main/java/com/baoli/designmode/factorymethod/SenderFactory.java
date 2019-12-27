package com.baoli.designmode.factorymethod;

/**
 * @description: 发送短信邮件工厂
 * @author: li baojian
 * @create: 2019/09/25 17:19
 */
public class SenderFactory {

    public Sender produce(String type){
        if("sms".equals(type)){
            return new SendSms();
        }else if("email".equals(type)){
            return  new SendEmail();
        }else {
            System.out.println("请输入正确的类型");
            return null;
        }
    }

    public static Sender produceSms(){
        return new SendSms();
    }

    public static Sender produceEmail(){
        return  new SendEmail();
    }
}
