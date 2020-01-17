package com.baoli.designmode.templateMethod;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @description: ģ�巽���е�ģ�������
 * @author: li baojian
 * @create: 2019/12/25 14:59
 */
public abstract class BaseCommand {
   public static final Logger log = LoggerFactory.getLogger(BaseCommand.class);
    public void execute(){

        log.info("��ʼ");
        //��ʼ���ܷ���
        System.out.println(new Date());
        //��ʼ����
        System.out.println("��ʼ����");
        doBusiness();
        //��������
        System.out.println("�ύ����");
        //���ܷ�������
        System.out.println(new Date());
        log.info("����");
    }
    //���󷽷�֮�����ʵ��
    protected abstract void doBusiness();
}
