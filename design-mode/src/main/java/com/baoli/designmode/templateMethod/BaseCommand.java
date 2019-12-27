package com.baoli.designmode.templateMethod;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * @description: ģ�巽���е�ģ�������
 * @author: li baojian
 * @create: 2019/12/25 14:59
 */
public abstract class BaseCommand {
   public static final Log log = LogFactory.getLog(BaseCommand.class);
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
