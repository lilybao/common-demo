package com.baoli.designmode.templateMethod;

/**
 * @description: �¶�����
 * @author: li baojian
 * @create: 2019/12/25 15:03
 */
public class PlaceOrderCommand extends BaseCommand {
    @Override
    protected void doBusiness() {
        //�¶�����ҵ�����
        log.info("�¶�������");
    }
}
